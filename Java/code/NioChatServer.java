package t2forum.chatServer;

import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.*;

public class NioChatServer implements Runnable {
    private final int port;
    private ServerSocketChannel ssc;
    private Selector selector;
    private ByteBuffer buf = ByteBuffer.allocate(256);

    private NioChatServer(int port) throws IOException {
        this.port = port;
        this.ssc = ServerSocketChannel.open();
        this.ssc.socket().bind(new InetSocketAddress(port));
        this.ssc.configureBlocking(false);
        this.selector = Selector.open();

        this.ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        try {
            System.out.println("Server starting on port " + this.port);
            Iterator<SelectionKey> iter;
            SelectionKey key;
            while (this.ssc.isOpen()) {
                selector.select();
                iter = this.selector.selectedKeys().iterator();
                while (iter.hasNext()) {
                    key = iter.next();
                    iter.remove();

                    if (key.isAcceptable()) this.handleAccept(key);
                    if (key.isReadable()) this.handleRead(key);
                }
            }
        } catch (IOException e) {
            System.out.println("IOException, server of port " + this.port + " terminating. Stack trace:");
            e.printStackTrace();
        }
    }

    private final ByteBuffer askNameBuf = ByteBuffer.wrap("Please input your name: ".getBytes());
    private final ByteBuffer welcomeBuf = ByteBuffer.wrap("Welcome to NioChat!\n".getBytes());

    private void handleAccept(SelectionKey key) throws IOException {
        SocketChannel sc = ((ServerSocketChannel) key.channel()).accept();
        String address = (new StringBuilder(sc.socket().getInetAddress().toString())).append(":").append(sc.socket().getPort()).toString();
        sc.configureBlocking(true);
        sc.write(askNameBuf);
        ByteBuffer nameBuf = ByteBuffer.allocate(32);
        sc.read(nameBuf);
        String name = new String(nameBuf.array(), Charset.forName("UTF-8")).trim();
        sc.configureBlocking(false);
        sc.register(selector, SelectionKey.OP_READ, name);
        String welName = name + ", ";
        ByteBuffer welNameBuf = ByteBuffer.wrap(welName.getBytes());
        sc.write(welNameBuf);
        sc.write(welcomeBuf);
        welcomeBuf.rewind();
        askNameBuf.rewind();
        ByteBuffer prompt = ByteBuffer.wrap("> ".getBytes());
        sc.write(prompt);
        System.out.println("accepted connection from: " + name + "@" + address);
    }

    private void handleRead(SelectionKey key) throws IOException {
        SocketChannel ch = (SocketChannel) key.channel();
        StringBuilder sb = new StringBuilder();
        buf.clear();
        int read;
        while ((read = ch.read(buf)) > 0) {
            buf.flip();
            byte[] bytes = new byte[buf.limit()];
            buf.get(bytes);
            sb.append(new String(bytes));
            buf.clear();
        }
        String msg;
        if (read < 0) {
            msg = key.attachment() + " left the chat.\n";
            ch.close();
        } else {
            msg = key.attachment() + ": " + sb.toString() + "\n> ";
        }

        System.out.println(msg);
        broadcast(msg);
    }

    private void broadcast(String msg) throws IOException {
        ByteBuffer msgBuf = ByteBuffer.wrap(msg.getBytes());
        for (SelectionKey key : selector.keys()) {
            if (key.isValid() && key.channel() instanceof SocketChannel) {
                SocketChannel sch = (SocketChannel) key.channel();
                sch.write(msgBuf);
                msgBuf.rewind();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        NioChatServer server = new NioChatServer(11200);
        (new Thread(server)).start();
    }
}

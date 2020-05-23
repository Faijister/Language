package net.mindview.util;


/**
 * @author Leo
 * @since 2016/10/2.
 */
public class Byte2BinaryString {
    public static String byte2BinaryString(byte b) {
        char[] buf = new char[8];
        if (b < 0) {
            b = (byte) (b* (-1));
            buf[0] = '1';
        }
        else {
            buf[0] = '0';
        }
        b = (byte) (b << 1);
        for (int i = 1; i < 8; i++) {
            buf[i] = ((b & 0x80) == 0) ? '0' : '1';
            b = (byte) (b << 1);
        }
        return new String(buf);
    }
}

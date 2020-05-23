package exercise.chap09;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

import static net.mindview.util.Print.print;

/** 
 * Create a class that produces a sequence of
 * chars. Adapt this class so that it can
 * be an input to a Scanner object
 * @author Leo
 * @since 2016/10/12
 */

class RandomChar implements Readable {
    private int count;
    private Random r = new Random();
    private static final char[] c;

    static {
        c = "ABCDEFGHIGKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    }

    RandomChar(int count) { this.count = count; }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if(count -- == 0)
            return -1;
        String result = Character.toString(c[r.nextInt(52)]) + " ";
        cb.append(result);
        return result.length();
    }
}
public class Exercise16 {
    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomChar(17));
        int i = 0;
        while(s.hasNext()) {
            print(++i + " : " + s.next());
        }
    }
}

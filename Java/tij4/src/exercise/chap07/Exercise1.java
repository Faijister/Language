package exercise.chap07;

import static net.mindview.util.Print.print;

/** 
 * Lazy initialization example
 * @author Leo
 * @since 2016/10/6
 */
public class Exercise1 {
    private static Simple simple;
    public static void main(String[] args) {
        simple = new Simple();
        print(simple);
    }
}

class Simple {
    String s;
    public String toString() {
        if (s == null)
            s = "Lazy initialization!";
        return s;
    }
}

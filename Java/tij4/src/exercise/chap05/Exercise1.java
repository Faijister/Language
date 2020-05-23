package exercise.chap05;

import static net.mindview.util.Print.print;

/** 
 * Create a class containing an uninitialized String
 * reference. Demonstrate that this reference is initialized
 * by Java to null
 * @author Leo
 * @since 2016/10/3
 */
public class Exercise1 {
    public static void main(String[] args) {
        StringClass o1 = new StringClass();
        print(o1.s);
        print(o1.c);
        if (o1.s == null)
            print("String will be initialized to null");
        if (o1.c == 0)
            print("char will be initialized to \\0");
    }
}

class StringClass {
    String s;
    char c;
}

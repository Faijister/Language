package exercise.chap03;

import static net.mindview.util.Print.print;

/** 
 * demonstrate aliasing during method calls
 * @author Leo
 * @since 2016/10/2.
 */
public class Exercise3 {
    static void discount(Book b) {
        b.price = b.price * 0.8f;
    }
    public static void main(String[] args) {
        Book thinkingInJava = new Book();
        thinkingInJava.price = 79.0f;
        print("1: book price is $" + thinkingInJava.price);

        discount(thinkingInJava);
        print("1: book price is $" + thinkingInJava.price);
    }
}

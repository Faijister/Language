package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Write a class named Outer that contains an inner class named Inner
 * Add a method to Outer that returns an object of type Inner.
 * In main(), create and initialize a reference to an Inner
 *
 * @author Leo
 * @since 2016/10/14
 */
public class Exercise1 {
    public static void main(String[] args) {
        Outer.main(args);
    }
}

class Outer {
    class Inner {
        String name = "Inner";

        Inner() {
            print(name);
        }
    }

    Inner createInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer o = new Outer();
        Inner i = o.createInner();
    }
}

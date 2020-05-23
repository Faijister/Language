package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Modify Exercise1 so that Outer has a private String
 * field(initialized by the constructor), and Inner has a toString() that
 * display this field. Create an object of type Inner and display it.
 *
 * @author Leo
 * @since 2016/10/16
 */
public class Exercise3 {
    public static void main(String[] args) {
        Outer.main(args);
    }
}

class Outer {
    private String name;

    Outer(String name) {
        this.name = name;
    }

    class Inner {
        public String toString() {
            return name;
        }
    }

    Inner createInner() {
        return new Inner();
    }

    public static void main(String[] args) {
        Outer o = new Outer("Exercise3");
        print(o.createInner());
    }
}

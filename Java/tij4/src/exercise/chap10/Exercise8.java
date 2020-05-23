package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Determine whether an outer class has access to the
 * private elements of its inner class. -->  YES
 *
 * @author Leo
 * @since 2016/10/21
 */
public class Exercise8 {
    public static void main(String[] args) {
        new Bottle().main(args);
    }
}

class Bottle {
    class Liquid {
        private String type = "unknown";

        private void showType() {
            print(type);
        }

    }

    public void main(String[] args) {
        Liquid l = new Liquid();
        l.showType();
        print("changing...");
        l.type = "exercise8";
        l.showType();
    }
}

package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create a class with an inner class. In a separate class,
 * make an instance of the inner class
 * @author Leo
 * @since 2016/10/19
 */
public class Exercise5 {
    public static void main(String[] args) {
        // first create an outer class object
        Outer1 outer = new Outer1();

        // then create inner class object use outer.new
        Outer1.Inner inner = outer.new Inner("Exercise5");
        print(inner);
    }
}

class Outer1 {
    class Inner {
        private String name;
        Inner(String name) {
            this.name = name;
        }
        public String toString() {
            return name;
        }
    }
}

package innerclass;

import interfaces.Innerable;

import static net.mindview.util.Print.print;

/**
 * Chap 10 inner classes exercise 6
 * Create an interface with at lease one method, in its own
 * package. -- interfaces.Innerable
 * <p>
 * Create a class in a separate package.
 * Add a protected inner class
 * that implements the interface. -- innerclass.Outer
 * <p>
 * In a third package, inherit from your class and
 * inside a method, return an object of the protected inner class, upcasting to
 * the interface during the return. -- exercise.chap10.Exercise6
 *
 * @author Leo
 * @since 2016/10/19
 */
public class Outer {
    protected class Inner implements Innerable {
        public Inner() { } // need public constructor to create one in Outer child
        @Override
        public void innerPrint() {
            print("exercise6");
        }
    }
}

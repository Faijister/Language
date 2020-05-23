package exercise.chap09;

import static net.mindview.util.Print.print;

/** 
 * Create a class as abstract
 * without including any abstract method
 * and verify that you cannot create any
 * instance of that class
 * @author Leo
 * @since 2016/10/8
 */
public class Exercise2 {
    public static void main(String[] args) {
//        AC ac = new AC();
//        AC1 ac1 = new AC1();
        /*
         * java: com.chap09.AC is abstract; cannot be instantiated
         *
         */
        C1 c1 = new C1();
    }
}

abstract class AC { }
abstract class AC1 {
    public AC1() {
        print("AC1");
    }
}

class C1 extends AC1 {
    public C1() {
        print("C1");
    }
}

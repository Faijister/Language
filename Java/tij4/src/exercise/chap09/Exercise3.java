package exercise.chap09;

import static org.greggordon.tools.Print.*;

/**
 * @author Leo
 * @since 2016/10/8
 */
public class Exercise3 {
    public static void main(String[] args) {
        Derived derived = new Derived();
        derived.print();
    }
}

abstract class Base {
    public Base() {
        print();
    }
    protected abstract void print();
}

class Derived extends Base {
    private int i = 1;
    @Override protected void print() {
        println("Derived.i = " + i);
    }
}

package exercise.chap07;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/6
 */
public class Exercise4 {
    public static void main(String[] args) {
        C c = new C();
    }
}

class A {
    A() {print("Constructor A");}
}

class B extends A {
    B() {print("Constructor B");}
}

class C extends A {
        B b = new B();
}

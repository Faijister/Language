package exercise.chap07;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/7
 */
public class Exercise9 {
    public static void main(String[] args) {
        Stem s = new Stem();
        try {
            print(s.toString());
        } finally {
            s.dispose();
        }
    }
}

class Component1 {
    Component1() {
        print("Component1 constructor");
    }
    void dispose() {
        print("Component1 dispose");
    }
}

class Component2 {
    Component2() {
        print("Component2 constructor");
    }
    void dispose() {
        print("Component2 dispose");
    }
}

class Component3 {
    Component3() {
        print("Component3 constructor");
    }
    void dispose() {
        print("Component3 dispose");
    }
}

class Root {
    Component1 c1root;
    Component2 c2root;
    Component3 c3root;
    Root() {
        print("Root constructor");
        c1root = new Component1();
        c2root = new Component2();
        c3root = new Component3();
    }
    void dispose() {
        c3root.dispose();
        c2root.dispose();
        c1root.dispose();
        print("Root dispose");
    }
}

class Stem extends Root {
    Component1 c1stem;
    Component2 c2stem;
    Component3 c3stem;
    Stem() {
        super();
        print("Stem constructor");
        c1stem = new Component1();
        c2stem = new Component2();
        c3stem = new Component3();
    }
    void dispose() {
        c3stem.dispose();
        c2stem.dispose();
        c1stem.dispose();
        print("Stem dispose");
        super.dispose();
    }
}

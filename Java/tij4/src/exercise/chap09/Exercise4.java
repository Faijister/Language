package exercise.chap09;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/8
 */
public class Exercise4 {
    public static void test1(Dad x) {
        x.show();
    }
    public static void main(String[] args) {
        Dad x = new Son();
        Exercise4.test1(x);
    }
}

abstract class Dad {
    abstract void show();
}
class Son extends Dad {
    void show() {
        print(getClass().getSimpleName());
    }
}

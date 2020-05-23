package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create a class with a private field and a private method
 * Create an inner class with a method that modifies the outer-class filed and
 * calls the outer-class method. In a second outer-class method, create an object
 * of the inner class and call its method, then show the effect on the outer-class
 * object
 *
 * @author Leo
 * @since 2016/10/21
 */
public class Exercise7 {
    public static void main(String[] args) {
        Computer c = new Computer();
        c.showType();
        c.changeType();
        c.showType();
    }
}

class Computer {
    private String type = "unknown";

    private void change() {
        print("changing...");
    }

    class TypeChanger {
        void innerChange() {
            type = "exercise7";
            change();
        }
    }

    void changeType() {
        TypeChanger tc = new TypeChanger();
        tc.innerChange();
    }

    void showType() {
        print(type);
    }

}

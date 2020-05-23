package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Repeat exercise7 using anonymous inner class
 * --- exercise7 ---
 * Create a class with a private field and a private method
 * Create an inner class with a method that modifies the outer-class filed and
 * calls the outer-class method. In a second outer-class method, create an object
 * of the inner class and call its method, then show the effect on the outer-class
 * object
 *
 * @author Leo
 * @since 2016/10/23
 */
public class Exercise12 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.showType();
        phone.getChanger().innerChange();
        phone.showType();
    }
}

interface Changeable {
    void innerChange();
}

class Phone {
    private String type = "unknown";

    private void change() {
        print("changing...");
    }

    public Changeable getChanger() {
        // Anonymous new Changeable() can be replaced with lambda
        /*
        return new Changeable() {
            @Override
            public void innerChange() {
                type = "exercise12";
                change();
            }
        }
        */
        return () -> {
            type = "exercise12";
            change();
        };
    }

    void showType() {
        print(type);
    }
}

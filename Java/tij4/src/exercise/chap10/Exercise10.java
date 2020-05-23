package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Repeat the previous exercise but define the inner class
 * within a scope within a method.
 *
 * @author Leo
 * @since 2016/10/22
 */
public class Exercise10 {
    public static void main(String[] args) {
        Bread bread = new Bread();
        if (bread.getEat() != null) {
            bread.getEat().eat();
        } else
            print("can not eat!");
    }
}

interface Eatable {
    void eat();
}

class Bread {
    private boolean canEat = true;

    Bread(boolean eatable) {
        canEat = eatable;
    }

    Bread() {
    }

    Eatable getEat() {
        if (canEat) {
            class EatImp implements Eatable {
                @Override
                public void eat() {
                    print("exercise10");
                }
            }
            return new EatImp();
        } else
            return null;
    }
}

package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create an interface with at least one method, and
 * implement that interface by defining an inner class within a method,
 * which returns a reference to your instance.
 *
 * @author Leo
 * @since 2016/10/22
 */
public class Exercise9 {
    public static void main(String[] args) {
        Water water = new Water();
        water.getDrink().drink();
    }
}

interface Drinkable {
    void drink();
}

class Water {
    Drinkable getDrink() {
        class DrinkImp implements Drinkable {
            @Override
            public void drink() {
                print("exercise9");
            }
        }
        return new DrinkImp();
    }
}
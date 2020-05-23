package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Repeat exercise9 using anonymous inner class
 * --- exercise9 ---
 * Create an interface with at least one method, and
 * implement that interface by defining an inner class within a method,
 * which returns a reference to your instance.
 *
 * @author Leo
 * @since 2016/10/23
 */
public class Exercise13 {
    public static void main(String[] args) {
        Beer beer = new Beer();
        beer.getDrink().drink();
    }
}

interface ReDrinkable {
    void drink();
}

class Beer {
    // Anonymous new Changeable() can be replaced with lambda
    /*
        ReDrinkable getDrink() {
            return new ReDrinkable {
                print("exercise13");
            }
        }
     */
    ReDrinkable getDrink() {
        return () -> {
          print("exercise13");
        };
    }
}
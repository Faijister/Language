package exercise.chap08;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/7
 */
public class Bicycle extends Cycle {
    @Override public void ride() {
        print("Bicycle ride");
    }
    public void balance() {
        print("Bicycle balance");
    }
}

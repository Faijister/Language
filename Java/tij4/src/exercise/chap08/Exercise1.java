package exercise.chap08;

/**
 * @author Leo
 * @since 2016/10/7
 */
public class Exercise1 {
    public static void main(String[] args) {
        Cycle[] cycles = {
            new Cycle(),
            new Unicycle(),
            new Bicycle(),
            new Tricycle()
        };
        for (Cycle c : cycles) {
            c.ride();
        }
    }
}

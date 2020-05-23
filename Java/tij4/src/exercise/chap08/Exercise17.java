package exercise.chap08;

/**
 * @author Leo
 * @since 2016/10/7
 */
public class Exercise17 {
    public static void main(String[] args) {
        Cycle[] cycles = {
                new Unicycle(),
                new Bicycle(),
                new Tricycle()
        };

        // try to call balance() on each element of the array
        // and observe the results
        /*
            java: cannot find symbol
            symbol: method balance()
            location: class exercise.chap08.Cycle
         */
//        cycles[0].balance();
//        cycles[1].balance();
//        cycles[2].balance();

        // Downcast and call balance() and observe what happens
        ((Unicycle)cycles[0]).balance();
        ((Bicycle)cycles[1]).balance();
        /*
            java: cannot find symbol
            symbol: method balance()
            location: class exercise.chap08.Tricycle
         */
//        ((Tricycle)cycles[2]).balance();
    }
}

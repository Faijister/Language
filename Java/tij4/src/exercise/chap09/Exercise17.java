package exercise.chap09;

import static net.mindview.util.Print.print;

/** 
 * Prove that the fields in an interface are implicitly static
 * and final
 * @author Leo
 * @since 2016/10/12
 */

interface Fixable {
    // int fitness
    /* = expected*/

    int fitness = 17;
    void fit1();
}

public class Exercise17 implements Fixable{
    @Override
    public void fit1() {
        print("fit1()");
    }

    public static void main(String[] args) {
        Exercise17 e = new Exercise17();
//        e.fit1();
//        print(e.fitness);
        /* Static member accessed via instance reference */
        print(Fixable.fitness);

//        Fixable.fitness ++;
        /* cannot assign a value to final variable fitness*/
    }
}

package exercise.chap03;

import java.util.Random;

import static net.mindview.util.Print.print;

/** 
 * Simulate coin-flipping
 * @author Leo
 * @since 2016/10/2.
 */
public class Exercise7 {
    public static void main(String[] args) {
        Random random = new Random();
        if (random.nextBoolean())
            print("HEAD");
        else print("BACK");
    }
}

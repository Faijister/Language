package exercise.chap04;

import java.util.Random;

import static net.mindview.util.Print.print;
import static net.mindview.util.Range.range;

/**
 * @author Leo
 * @since 2016/10/2
 */
public class ForEachFloat {
    public static void main(String[] args) {
        float[] f = new float[10];
        Random rdm = new Random(47);
        for(int i : range(10)) {
            f[i] = rdm.nextFloat();
        }
        for(float x : f ) {
            print(x);
        }
    }
}

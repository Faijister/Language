package exercise.chap03;

import java.util.Random;

import static net.mindview.util.Print.print;

/** 
 * calculates velocity
 * @author Leo
 * @since 2016/10/2.
 */
public class Exercise4 {
    public static void main(String[] args) {
        Random random = new Random(47);
        float dis = random.nextFloat();
        float t = random.nextFloat();
        print("distance: " + dis);
        print("time: " + t);
        print("velocity: " + VelocityCalculator.velocity(dis, t));
        print("velocity: " + VelocityCalculator.velocity(dis, 0));
    }
}

class VelocityCalculator {
    static float velocity(float distance, float time) {
        if(time == 0)
            return 0;
        return distance/time;
    }
}

package exercise.chap09;

import java.util.Random;

import static net.mindview.util.Print.print;

/**
 * Create a framework using Factory Methods that
 * perform both coin tossing and dice tossing.
 *
 * @author Leo
 * @since 2016/10/13
 */
public class Exercise19 {
    public static void tossIt(TossFactory tf) {
        Tossable t = tf.getToss();
        t.toss();
    }

    public static void main(String[] args) {
        tossIt(new CoinTossFactory());
        tossIt(new DiceTossFactory());
    }
}

interface Tossable {
    void toss();
}

interface TossFactory {
    Tossable getToss();
}

class CoinToss implements Tossable {
    private Random random = new Random();

    @Override
    public void toss() {
        print("Coin toss - " + (random.nextBoolean() ? "HEAD" : "TAIL"));
    }
}

class CoinTossFactory implements TossFactory {
    @Override
    public Tossable getToss() {
        return new CoinToss();
    }
}

class DiceToss implements Tossable {
    private Random random = new Random();

    @Override
    public void toss() {
        print("Dice toss - " + (1 + random.nextInt(6)));
    }
}

class DiceTossFactory implements TossFactory {
    @Override
    public Tossable getToss() {
        return new DiceToss();
    }
}

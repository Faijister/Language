package exercise.chap09;

import static net.mindview.util.Print.print;

/** 
 * Create a Cycle interface,
 *  with implementations: Unicycle, Bicycle, Tricycle
 *  Create factories for each type of Cycle
 *  and code that uses these factories
 * @author Leo
 * @since 2016/10/13
 */
public class Exercise18 {
    public static void cycleRide(CycleFactory cf) {
        Cycle c = cf.getCycle();
        c.ride();
    }
    public static void main(String[] args) {
        cycleRide(new UnicycleFactory());
        cycleRide(new BicycleFactory());
        cycleRide(new TricycleFactory());
    }
}

interface Cycle {
    void ride();
}

interface CycleFactory {
    Cycle getCycle();
}
class Unicycle implements Cycle {
    @Override
    public void ride() {
        print("Unicycle ride");
    }
}
class UnicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    @Override
    public void ride() {
        print("Bicycle ride");
    }
}

class BicycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    @Override
    public void ride() {
        print("Tricycle ride");
    }
}

class TricycleFactory implements CycleFactory {
    @Override
    public Cycle getCycle() {
        return new Tricycle();
    }
}

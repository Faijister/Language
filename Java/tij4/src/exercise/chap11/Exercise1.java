package exercise.chap11;

import java.util.ArrayList;

import static net.mindview.util.Print.print;

/**
 * Create a new class called Gerbil with an int gerbilNumber that's
 * initialized in the constructor. Give it a method called hop() that displays
 * which gerbil number that is, and that it's hopping. Create an ArrayList and
 * add Gerbil objects to the List. Now use the get() method to move through
 * the List and call hop() for each Gerbil.
 *
 * @author Leo
 * @since 2016/10/26
 */
public class Exercise1 {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(7));
        gerbils.add(new Gerbil(17));
        gerbils.add(new Gerbil(77));

        /*
        for(Gerbil g : gerbils) {
            g.hop();
        }
        */

        gerbils.forEach(Gerbil::hop);
    }
}

class Gerbil {
    int gerbilNumber;

    Gerbil(int num) {
        gerbilNumber = num;
    }

    void hop() {
        print("Gerbil " + gerbilNumber + " is hopping...");
    }
}

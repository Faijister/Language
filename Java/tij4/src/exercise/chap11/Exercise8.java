package exercise.chap11;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Modify Exercise 1 so it uses an Iterator to move through
 * the List while calling hop().
 *
 * @author Leo
 * @since 2016/11/3
 */
public class Exercise8 {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<>();
        gerbils.add(new Gerbil(7));
        gerbils.add(new Gerbil(17));
        gerbils.add(new Gerbil(77));

        Iterator<Gerbil> it = gerbils.iterator();
        while (it.hasNext())
            it.next().hop();
    }
}

package exercise.chap11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static net.mindview.util.Print.print;
import static net.mindview.util.Range.range;

/**
 * Modify ListFeatures.java so that it uses Integers
 * (remember autoboxing) instead of Pets, and explain any difference in
 * results
 *
 * @author Leo
 * @since 2016/10/28
 */
public class Exercise5 {
    public static void main(String[] args) {
        Random random = new Random(37);
        List<Integer> number = new ArrayList<>(7);
        for(int i : range(7))
            number.add(random.nextInt());
        print("1: " + number);

        number.add(77777); // Auto resize
        print("2: " + number);

        print("3: " + number.contains(77777));

        number.remove((Integer)77777);
        print("3: " + number);


        Integer i = number.get(2);
        print("4: " + i + " " + number.indexOf(i));
        // Not need exact object
        Integer j = -2014573909;
        print("5: " + number.indexOf(j));
        print("6: " + number.remove(j));
        print("7: " + number.remove(i));
        print("8: " + number);

        number.add(3, 20160605);
        print("9: " + number);

        List<Integer> sub = number.subList(1,4);
        print("subList: " + sub);
        print("10: " + number.containsAll(sub));

        Collections.sort(sub);
        print("sorted sublist: " + sub);
        // change of the sub list is reflect to the original list
        print("11: " + number);

        Collections.shuffle(sub, random);
        print("shuffled sublist: " + sub);
        print("12: " + number);
    }
}



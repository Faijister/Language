package exercise.chap11;

import net.mindview.util.Print;

import java.util.HashSet;
import java.util.Set;

/**
 * Modify SimpleCollection.java to use a Set for c.
 *
 * @author Leo
 * @since 2016/10/26
 */
public class Exercise2 {
}

class SimpleCollection {
    public static void main(String[] args) {
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < 10; i++) {
            s.add(i);
        }
        /*
        for(Integer i : s) {
            print(i);
        }
         */
        s.forEach(Print::print);
    }
}
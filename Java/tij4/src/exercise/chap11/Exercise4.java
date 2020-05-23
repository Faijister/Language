package exercise.chap11;

import java.util.*;

import static net.mindview.util.Print.print;

/**
 * Create a generator class that produces character names
 * (as String objects) from your favorite movie (you can use Snow White or
 * Star Wars as a fallback) each time you call next(), and loop around to the
 * beginning of the character list when it runs out of names. Use this generator
 * to fill an array, an ArrayList, a LinkedList, a HashSet, a
 * LinkedHashSet, and a TreeSet, then print each container.
 *
 * @author Leo
 * @since 2016/10/27
 */
public class Exercise4 {
    private static Generator generator = new Generator();

    static Collection fill(Collection<String> collection) {
        generator.reset();
        while (!generator.end())
            collection.add(generator.next());
        return collection;
    }

    public static void main(String[] args) {
        print(fill(new ArrayList<>()));
        print(fill(new LinkedList<>()));
        print(fill(new HashSet<>()));
        print(fill(new LinkedHashSet<>()));
        print(fill(new TreeSet<>()));
    }
}

class Generator {
    private static final String[] character_names = {
            "Audrey Hepburn", "Vivien Leigh",
            "Al Pacino", "Tom Hanks", "Dustin Hoffman",
            "Tom Cruise", "Leonardo DiCaprio"};

    int index = 0;

    boolean end() {
        return index == character_names.length;
    }

    String next() {
        return character_names[index++];
    }

    void reset() {
        index = 0;
    }
}
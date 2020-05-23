package exercise.chap11;

import java.util.ArrayList;

import static net.mindview.util.Print.print;

/**
 * Modify innerclass/Sequence.java so that you can
 * add any number of elements to it.
 *
 * @author Leo
 * @since 2016/10/27
 */
public class Exercise3 {
    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        sequence.add("Leo");
        sequence.add("Fu");
        sequence.add("Exercise");
        sequence.add(3);
        sequence.add("Goodbye");

        print(sequence);

        Selector selector = sequence.selector();
        while (!selector.end()) {
            print(selector.current());
            selector.next();
        }
    }
}

interface Selector {
    boolean end();

    Object current();

    void next();
}

class Sequence {
    public String toString() {
        return items.toString();
    }

    private ArrayList<Object> items = new ArrayList<>();

    public void add(Object x) {
        items.add(x);
    }

    private class SeqSelector implements Selector {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.size();
        }

        @Override
        public Object current() {
            return items.get(i);
        }

        @Override
        public void next() {
            i++;
        }
    }

    public Selector selector() {
        return new SeqSelector();
    }
}
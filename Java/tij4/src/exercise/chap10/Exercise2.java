package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create a class that holds a String, and has a toString()
 * method that displays this String. Add several instances of your
 * new class to a Sequence object, then display them
 *
 * @author Leo
 * @since 2016/10/16
 */
public class Exercise2 {
    public static void main(String[] args) {
        Sequence.main(args);
    }
}


class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

interface Selectable {
    boolean end();

    Object current();

    void next();
}

class Sequence {
    private Object[] items;
    private int index = 0;

    public void add(Object o) {
        items[index++] = o;
    }

    Sequence(int s) {
        items = new Object[s];
    }

    class SeqSelector implements Selectable {
        private int i = 0;

        @Override
        public boolean end() {
            return i == items.length;
        }

        @Override
        public Object current() {
            return items[i];
        }

        @Override
        public void next() {
            if (i < items.length)
                i++;
        }
    }

    public Selectable createSeqSelector() {
        return new SeqSelector();
    }

    public static void main(String[] args) {
        Sequence family = new Sequence(4);
        family.add(new Person("Leo"));
        family.add(new Person("Jane"));
        family.add(new Person("Orchid"));
        family.add(new Person("Bean"));
        Selectable selector = family.createSeqSelector();

        while (!selector.end()) {
            print(selector.current());
            selector.next();
        }

    }
}

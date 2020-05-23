package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Add a method to the class
 * Sequence.SeqSelector that produces the reference to the outer
 * class Sequence.
 *
 * @author Leo
 * @since 2016/10/18
 */
public class Exercise4 {
    public static void main(String[] args) {
        Sequence1.main(args);
    }
}

class Book {
    String name;

    Book(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}

class Sequence1 {
    private Object[] items;
    private int index = 0;

    public void add(Object o) {
        items[index++] = o;
    }

    Sequence1(int i) {
        items = new Object[i];
    }

    public String toString() {
        return "Exercise4";
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

        public Sequence1 outer() {
            return Sequence1.this;
        }
    }

    public Selectable createSeqSelector() {
        return new SeqSelector();
    }

    public static void main(String[] args) {
        Sequence1 s = new Sequence1(4);
        s.add(new Book("TIJ4"));
        s.add(new Book("CSAPP"));
        s.add(new Book("TAOPC"));
        s.add(new Book("APUE"));

        Selectable selector = s.createSeqSelector();

        while (!selector.end()) {
            print(selector.current());
            selector.next();
        }

        print(((SeqSelector) selector).outer());
    }
}


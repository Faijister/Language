package exercise.chap09;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/** 
 * Refactor Music5.java by moving the common methods
 *  in Wind, Percussion, and Stringed into an abstract class
 * @author Leo
 * @since 2016/10/11
 */


//interface Instrument {
//    void play(Note n);  // Automatically public
//}

abstract class Instrument {
    abstract void play(Note n); // Abstract class
}

class Wind extends Instrument {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Wind"; }
}

class Percussion extends Instrument {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Percussion"; }
}

class Stringed extends Instrument {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
    public String toString() { return "Stringed"; }
}

class Brass extends Wind {
    public String toString() { return "Brass"; }
}

class Woodwind extends Wind {
    public String toString() { return "Woodwind"; }
}

public class Exercise9 {
    // Doesn't care about type, so new types
    // added to the system will work right:
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        Instrument[] orchestrator = {
                new Wind(),
                new Percussion(),
                new Stringed(),
                new Brass(),
                new Woodwind()
        };
        tuneAll(orchestrator);
    }
}

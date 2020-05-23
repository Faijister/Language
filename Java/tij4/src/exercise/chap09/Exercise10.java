package exercise.chap09;

import polymorphism.music.Note;

import static net.mindview.util.Print.print;

/** 
 * Modify Music5.java by adding a Playable interface.
 *  Move the play() declaration from Instrument to Playable
 * @author Leo
 * @since 2016/10/11
 */

interface Playable {
    void play(Note n);
}

class Wind1 implements Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
}
class Stringed1 implements Playable {
    public void play(Note n) {
        print(this + ".play() " + n);
    }
}

public class Exercise10 {
    static void tune(Playable p) {
        p.play(Note.B_FLAT);
    }
    static void tuneAll(Playable[] pls) {
        for (Playable p: pls) {
            tune(p);
        }
    }
    public static void main(String[] args) {
        Playable[] pa = {
                new Wind1(),
                new Stringed1()
        };
        tuneAll(pa);
    }
}

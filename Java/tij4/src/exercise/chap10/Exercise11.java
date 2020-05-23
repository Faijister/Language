package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create a private inner class that implements a public
 * interface. Writer a method that returns a reference to an instance of the
 * private inner class, upcast to the interface. Show that the inner class is
 * completely hidden by trying to downcast to it.
 *
 * @author Leo
 * @since 2016/10/22
 */
public class Exercise11 {
    public static void main(String[] args) {
        Game game = new Game();
        game.getWow().play();

//        ((Wow)game.getWow()).play();
        /* java: cannot find symbol
        *  symbol: class Wow
        * */
    }
}

interface Playable {
    void play();
}

class Game {
    private class Wow implements Playable {
        @Override
        public void play() {
            print("exercise11");
        }
    }

    Playable getWow() {
        return this.new Wow();
    }
}
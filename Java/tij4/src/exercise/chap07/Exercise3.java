package exercise.chap07;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/7
 */
public class Exercise3 {
    public static void main(String[] args) {
        Cartoon x = new Cartoon();
    }
}

class Art {
    Art() {
        print("Art constructor");
    }
}

class Drawing extends Art {
    Drawing() {
        print("Drawing constructor");
    }
}

class Cartoon extends Drawing {

}

package exercise.chap04;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/2.
 */
public class IfElse {
    static int result = 0;
    static void test(int testVal, int targetVal) {
        if (testVal > targetVal)
            result = +1;
        else if (testVal < targetVal)
            result = -1;
        else
            result = 0;
    }

    public static void main(String[] args) {
        test(5 , 10);
        print(result);

        test(10 , 5);
        print(result);

        test(7 , 7);
        print(result);
    }
}

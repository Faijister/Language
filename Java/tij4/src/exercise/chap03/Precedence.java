package exercise.chap03;

/**
 * @author Leo
 * @since 2016/10/1.
 */
public class Precedence {
    /**
     * Operator precedence defines how an expression evaluates when several
     * operators are present.
     */
    public static void main(String[] args) {
        int x = 1, y = 2, z = 3;
        int a = x + y - 2/2 + z;
        int b = x + (y - 2)/(2 + z);
        System.out.println("a = " + a + " b = " + b);
    }
}

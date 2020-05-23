package exercise.chap03;

import java.util.Date;

/** 
 * Write a program that uses the "short" and normal
 * form of print statement
 * @author Leo
 * @since 2016/10/2.
 */
public class Exercise1 {
    public static void main(String[] args) {
        shortPrint("shortPint: Hello, world!");
        shortPrint(new Date());
        System.out.println("normalPrint: Hello, world!");
    }

    private static void shortPrint(Object o) {
        System.out.println(o);
    }
}

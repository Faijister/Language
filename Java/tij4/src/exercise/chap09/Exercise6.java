package exercise.chap09;

import java.util.Random;

import static net.mindview.util.Print.print;

/** 
 * Change Exercise9 in the Polymorphism chapter so that
 * Rodent is an interface
 * @author Leo
 * @since 2016/10/9
 */
public class Exercise6 {
    private static RandomRodentGenerator1 gen = new RandomRodentGenerator1();
    public static void main(String[] args) {
        Rodent1[] rodents;
        rodents = new Rodent1[10];
        for(Rodent1 r : rodents) {
            r = gen.next();
            print(r + ": ");
            r.eat();
            r.run();
            r.sleep();
        }
    }
}


interface Rodent1 {
    String name = "Rodent";
    void eat();
    void run();
    void sleep();
}

class Mouse1 implements Rodent1 {
    public void eat() { print("Mouse.eat()"); }
    public void run() { print("Mouse.run()"); }
    public void sleep() { print("Mouse.sleep()"); }
    public String toString() {
        return "Mouse"; }
}

class Rat1 implements Rodent1 {
    public void eat() { print("Rat.eat()"); }
    public void run() { print("Rat.run()"); }
    public void sleep() { print("Rat.sleep()"); }
    public String toString() {
        return "Rat"; }
}

class Squirrel1 implements Rodent1 {
    public void eat() { print("Squirrel.eat()"); }
    public void run() { print("Squirrel.run()"); }
    public void sleep() { print("Squirrel.sleep()"); }
    public String toString() {
        return "Squirrel"; }
}


class RandomRodentGenerator1 {
    private Random rand = new Random();
    public Rodent1 next() {
        switch(rand.nextInt(3)) {
            default:
            case 0: return new Mouse1();
            case 1: return new Rat1();
            case 2: return new Squirrel1();
        }
    }
}

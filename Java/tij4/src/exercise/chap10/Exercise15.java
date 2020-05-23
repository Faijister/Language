package exercise.chap10;

import static net.mindview.util.Print.print;

/**
 * Create a class with a non-default constructor (one with
 * arguments) and no default constructor (no "no-arg" constructor).
 * Create a second class that has a method that returns a reference to an object of the
 * first class. Create the object that you return by making an anonymous inner
 * class that inherits from the first class.
 *
 * @author Leo
 * @since 2016/10/24
 */
public class Exercise15 {
    public static void main(String[] args) {
        SecondClass secondClass = new SecondClass();
        secondClass.getFirstClass("exercise15").execute();
    }
}

class FirstClass {
    protected String name;

    FirstClass(String name) {
        this.name = name;
    }

    void execute() {
    }
}

class SecondClass {
    FirstClass getFirstClass(String name) {
        class FirstClassExt extends FirstClass {
            FirstClassExt(String name) {
                super(name);
                this.name = name;
            }

            @Override
            void execute() {
                print(this.name);
            }
        }
        return new FirstClassExt(name);
    }
}
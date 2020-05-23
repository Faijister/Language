package exercise.chap07;

import static net.mindview.util.Print.print;

/** 
 * delegation
 * @author Leo
 * @since 2016/10/7
 */
public class Exercise11 {
    public static void main(String[] args) {
        print("Testing Detergent class:");
        Detergent.main(args);
        print("========================");
        print("Testing Cleanser class:");
        Cleanser.main(args);
    }
}

class Cleanser {
    private String s = "Cleanser";
    public void append(String a) { s += a; }
    public void dilute() { append(" dilute()"); }
    public void apply() { append(" apply()"); }
    public void scrub() { append(" scrub()"); }
    public String toString() { return s; }

    public static void main(String[] args) {
        Cleanser x = new Cleanser();
        x.dilute(); x.apply(); x.scrub();
        print(x);
    }
}

class Detergent {
    Cleanser c = new Cleanser();
    public void dilute() { c.dilute(); }
    public void apply() { c.apply(); }
    public void scrub() { c.append(" Detergent.scrub()"); c.scrub(); }
    public void foam() { c.append(" foam()"); }
    public String toString() { return c.toString(); }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute(); x.apply(); x.scrub(); x.foam();
        print(x);
    }
}

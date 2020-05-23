package exercise.chap09;

import static net.mindview.util.Print.print;

/**
 * Create an interface (Playable) containing three
 * methods, in its own package interfaces.exercise5
 * Implement the interface in a different package
 * @author Leo
 * @since 2016/10/9
 */
public class Exercise5 implements interfaces.exercise5.Playable {
//     void play() {
    /* play() in com.chap09.Exercise5 cannot
    *  implement play() in interfaces.exercise5.Playable
    *  attempting to assign weaker access privileges; was public
    * */
    public void play() {
        print("Baby is playing!");
    }

//    protected void tired() {
    /* tired() in com.chap09.Exercise5 cannot
    *  implement tired() in interfaces.exercise5.Playable
    *  attempting to assign weaker access privileges; was public
    * */
    public void tired() {
        print("Baby is tired!");
    }

//    private void sleep() {
    /* sleep() in com.chap09.Exercise5 cannot
    *  implement sleep() in interfaces.exercise5.Playable
    *  attempting to assign weaker access privileges; was public
    * */
    public void sleep() {
        print("Baby is sleeping!");
    }

    public static void main(String[] args) {
        Exercise5 x = new Exercise5();
        x.play(); x.tired(); x.sleep();
    }
}

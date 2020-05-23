package exercise.chap06;

import static net.mindview.util.Print.print;
import static net.mindview.util.Range.range;

/** 
 * Create a class called ConnectionManager that manager a fix array of
 *  Connection objects. The client programmer must not be able to
 *  explicitly create Connection objects, but can only get them via a static
 *  method in ConnectionManager. When the ConnectionManager runs out of
 *  objects, it returns a null reference.
 * @author Leo
 * @since 2016/10/4
 */
public class Exercise8 {
    public static void main(String[] args) {
        for (int i : range(9)) {
            if (ConnectionManager.createConnection() != null) {
                print("New connection created successfully!");
            }
            else
                print("New connection created failed!");
        }
        ConnectionManager.getConnections();
    }
}

class ConnectionManager {
    private static int MAX_CONNECTION = 8;
    private static int counter = 0;
    private static Connection[] connections = new Connection[MAX_CONNECTION];
    public int getMaxConnection() {
        return MAX_CONNECTION;
    }
    public static Connection createConnection() {
        if (counter >= 8) {
            print("8 connections used up!");
            return null;
        }else {
            Connection c = Connection.createConnection();
            connections[counter] = c;
            counter ++;
            return c;
        }
    }
    public static void getConnections() {
        for (int i: range(MAX_CONNECTION))
            print(connections[i]);
    }
}

class Connection {
    private static int marker = 0;
    private Connection() {print("Connection " + ++marker + " is created!");}
    public static Connection createConnection() {
        return new Connection();
    }
}

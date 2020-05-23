package interfaces;

import static net.mindview.util.Print.print;

/**
 * Test JDK 1.8 Interface new feature
 * static method
 * default method
 * @author Leo
 * @since 2016/10/15
 */
public class InterfaceDefaultTest {
    public static void main(String[] args) {
        JDK8InterfaceImpl.main(args);
    }
}

interface JDK8Interface {
    static void method1() {
        print("JDK8 interface static method");
    }

    default void method2() {
        print("JDK8 interface default method");
    }
}

class JDK8InterfaceImpl implements JDK8Interface {
    public static void main(String[] args) {
        JDK8Interface.method1();
        JDK8InterfaceImpl x = new JDK8InterfaceImpl();
        x.method2();
    }
}

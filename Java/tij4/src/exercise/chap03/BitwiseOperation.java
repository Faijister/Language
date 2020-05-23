package exercise.chap03;

import static net.mindview.util.Byte2BinaryString.byte2BinaryString;
import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/2.
 */
public class BitwiseOperation {
    public static void main(String[] args) {
//        int num1 =  0b10101010;
//        int num2 =  0b01010101;
//
//        print(Integer.toBinaryString(num1));
//        print(Integer.toBinaryString(num2));
//
//        int result;
//        result =  (num1 & num2);
//        print(Integer.toBinaryString(result));
//
//        result =  (num1 | num2);
//        print(Integer.toBinaryString(result));
//
//        result = ~num1;
//        print(Integer.toBinaryString(result));
//
//        result = ~num2;
//        print(Integer.toBinaryString(result));
//
        byte b1 = -128;
        print(byte2BinaryString(b1));
        byte b2 = 85;
        print(byte2BinaryString(b2));
//        print(byte2BinaryString((byte) (b1 & b2)));
//        print(byte2BinaryString((byte) (b1 | b2)));
//        print(b1 & b2);
//        print(b1 | b2);
    }
}

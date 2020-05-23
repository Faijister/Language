package exercise.chap03;

import static net.mindview.util.Print.print;

/**
 * @author Leo
 * @since 2016/10/2.
 */
public class Exercise2 {
	public static void main(String[] args) {
		Book b1 = new Book();
        b1.price = 3.14f;
        Book b2 = new Book();
        b2.price = 7.23f;
        print("1: first book price is $" + b1.price + " while second book price is $" + b2.price);

        //aliasing
        b1 = b2;
        print("2: first book price is $" + b1.price + " while second book price is $" + b2.price);

        b1.price = 6.50f;
        print("3: first book price is $" + b1.price + " while second book price is $" + b2.price);
	}
}

class Book {
	float price;
}

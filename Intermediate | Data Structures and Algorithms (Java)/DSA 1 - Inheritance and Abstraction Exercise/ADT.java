
import java.util.Scanner;

/**
 *
 * @author williamscott
 */
abstract class Shape {

    abstract double draw(String shapeInput);

    void delete() {
        System.out.println("\nShape deleted");
    }
}

class Circle extends Shape {

    @Override
    double draw(String shapeInput) {
        System.out.println("\nDraw Circle");
        System.out.println(shapeInput.length());
        System.out.println(shapeInput);
        double radius = shapeInput.length() / 2.0;
        return (radius * radius * 22 / 7);
    }

    @Override
    void delete() {
        System.out.println("\nCircle Deleted");
    }
}

class Elcircle extends Shape {

    @Override
    double draw(String elcircleInput) {
        System.out.println("\nDraw Elcircle");

        String finalString = "";

        for (int i = 0; i < elcircleInput.length() - 1; i++) {
            finalString = elcircleInput.charAt(i) + finalString;
        }

        System.out.println(finalString.length());
        System.out.println(finalString);

        return finalString.length() * finalString.length();
    }

}

public class ADT {

    public static void main(String[] args) {

        Shape circle = new Circle();

        Shape elcircle = new Elcircle();

        System.out.println("Please enter the String");
        Scanner in = new Scanner(System.in);

        String input = in.nextLine();

        System.out.println(circle.draw(input));
        System.out.println(elcircle.draw(input));

        circle.delete();
        elcircle.delete();
    }

}

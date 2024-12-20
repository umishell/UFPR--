package areaCalculator_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AreaCalculator {

    public static void isNegative(double number) throws RuntimeException {
        if (number < 0) {
            throw new RuntimeException("Must be a positive number");

        }
    }

    public static double rectangleArea(double side1, double side2) {
        return side1 * side2;
    }

    public static double triangleArea(double side1, double side2) {
        return side1 * side2 / 2;
    }

    public static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Calculate the area of a: \n" +
                "Triangle = 1\n" +
                "Rectangle = 2\n" +
                "Circle = 3\n" +
                "option:");

        int choice = 0 ;
        try {
            choice = scan.nextInt();
            System.out.println("You entered: " + choice);
            if (choice != 1 && choice != 2 && choice != 3) {  // Use && for logical AND
                System.out.println("type the number options");
                choice = scan.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter an integer.");
            choice = scan.nextInt();
        }

        if (choice < 1 &&  choice > 3) {  // Use && for logical AND
            System.out.println("type the number options");
        }



            switch (choice) {
                case 1 -> {
                    System.out.println("type two side numbers :");
                    System.out.println("side one:");
                    double side1 = scan.nextDouble();
                    isNegative(side1);
                    System.out.println("side two:");
                    double side2 = scan.nextDouble();
                    isNegative(side2);
                    System.out.println("area of triangle is " + triangleArea(side1, side2) + " square meters");
                }
                case 2 -> {
                    System.out.println("type two side numbers :");
                    System.out.println("side one:");
                    double side1 = scan.nextDouble();
                    isNegative(side1);
                    System.out.println("side two:");
                    double side2 = scan.nextDouble();
                    isNegative(side2);
                    System.out.println("area of triangle is " + rectangleArea(side1, side2) + " square meters");
                }
                case 3 -> {
                    System.out.println("type radius :");
                    double radius = scan.nextDouble();
                    isNegative(radius);
                    isNegative(radius);
                    System.out.println("area of circle is " + String.format("%.2f", circleArea(radius)) + " square meters");
                }
            }
        scan.close();
    }

}

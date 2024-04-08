package formas_3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UseShapes {


    public static void isNegative(double number) throws RuntimeException {
        if (number < 0) {
            throw new RuntimeException("Must be a positive number");
        }
    }

    //                 MAIN
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("How many shapes?");
        int totalShapes = scan.nextInt();
        int choice=0;

        Circle[] circles = new Circle[totalShapes];
        Rectangle[] rectangles = new Rectangle[totalShapes];
        Triangle[] triangles = new Triangle[totalShapes];
        int trianglesPos = 0, rectanglesPos = 0, circlesPos = 0;
        Triangle triangle; Rectangle rectangle; Circle circle;

        for (int i = 0; i < totalShapes; i++) {
            System.out.print("Create a : \n" +
                    "Triangle = 1\n" +
                    "Rectangle = 2\n" +
                    "Circle = 3\n" +
                    "option:");
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

            if (choice < 1 && choice > 3) {  // Use && for logical AND
                System.out.println("type the number options");
            }


            switch (choice) {
                case 1 -> {
                    System.out.println("type the base and height of triangle in meters:");
                    System.out.println("base:");
                    double base = scan.nextDouble();
                    isNegative(base);
                    System.out.println("height:");
                    double height = scan.nextDouble();
                    isNegative(height);
                    triangle = new Triangle(base, height);
                    triangles[trianglesPos] = triangle;
                    trianglesPos++;
                }
                case 2 -> {
                    System.out.println("type the two sides of a rectangle in meters:");
                    System.out.println("side one:");
                    double side1 = scan.nextDouble();
                    isNegative(side1);
                    System.out.println("side two:");
                    double side2 = scan.nextDouble();
                    isNegative(side2);
                    rectangle = new Rectangle(side1, side2);
                    rectangles[rectanglesPos] = rectangle;
                    rectanglesPos++;
                }
                case 3 -> {
                    System.out.println("type radius of circle in meters:");
                    double radius = scan.nextDouble();
                    isNegative(radius);
                    circle = new Circle(radius);
                    circles[circlesPos] = circle;
                    circlesPos++;
                }
            }
        }
        int shapesCreated = (trianglesPos+rectanglesPos+circlesPos);
        System.out.println(shapesCreated+" shapes created.");

        for (int i = 0; i < trianglesPos; i++) {
            System.out.println("area of triangle "+ (i+1) +" = "+ triangles[i].area()+" square meters");
        }
        for (int i = 0; i < rectanglesPos; i++) {
            System.out.println("area of rectangle "+ (i+1) +" = "+ rectangles[i].area()+" square meters");
        }
        for (int i = 0; i < circlesPos; i++) {
            System.out.printf("area of circle %d = %.2f square meters%n", i + 1, circles[i].area());
        }
    }
}


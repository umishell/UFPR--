package formas_3;

public class Rectangle {

    private double side1, side2;

    public Rectangle(double side1, double side2){
        this.side1 = side1;
        this.side2 = side2;
    }

    public double area() {
        return side1 * side2;
    }

    public double perimeter(){
        return 2*side1+2*side2;
    }



}

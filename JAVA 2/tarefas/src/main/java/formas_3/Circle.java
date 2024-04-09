package formas_3;

public class Circle {

    private double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double area()  {
        return Math.PI * radius * radius;
    }
}

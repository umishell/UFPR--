package formas_3;

public class Triangle {
    private double base;
    private double hight;

    public Triangle(double base, double hight) {
        this.base = base;
        this.hight = hight;
    }

    public double area() {
        return base * hight / 2;
    }
}

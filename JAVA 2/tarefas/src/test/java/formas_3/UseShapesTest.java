package formas_3;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

@Nested
class UseShapesTest {

    @Test
    void rectangleArea_side2_8(){
        Rectangle rec = new Rectangle(2, 8);
        assertEquals(16, rec.area());
    }
    @Test
    void rectangleArea_side3_6(){
        Rectangle rec = new Rectangle(3, 6);
        assertEquals(18, rec.area());
    }
    @Test
    void rectanglePerimeter_side2_4(){
        Rectangle rec = new Rectangle(2, 4);
        assertEquals(12, rec.perimeter());
    }
    @Test
    void rectanglePerimeter_side3_9(){
        Rectangle rec = new Rectangle(3, 9);
        assertEquals(24, rec.perimeter());}
    }
    @Test
    void triangleArea_b2_h8(){
    Triangle tri = new Triangle(2, 8);
    assertEquals(8, tri.area());
    }
    @Test
    void triangleArea_b2_h10(){
        Triangle tri = new Triangle(2, 10);
        assertEquals(10, tri.area());
    }
    @Test
    void circleArea_radius10(){
        Circle cir = new Circle(10);
        assertEquals(314.15, cir.area());
    }
    @Test
    void  circleArea_radius3(){
        Circle cir  = new Circle(3);
        assertEquals(28.274333882308138, cir.area());
    }
}

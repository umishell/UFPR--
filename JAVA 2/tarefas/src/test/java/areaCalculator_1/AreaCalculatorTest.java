package areaCalculator_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AreaCalculatorTest {

    @Test
    void rectangleArea_side2(){
        assertEquals(4, AreaCalculator.rectangleArea(2,2));
    }
    @Test
    void rectangleArea_side3(){
        assertEquals(9, AreaCalculator.rectangleArea(3,3));
    }
    @Test
    void triangleArea_side2(){
        assertEquals(8, AreaCalculator.triangleArea(4,4));
    }
    @Test
    void triangleArea_side10(){
        assertEquals(50, AreaCalculator.triangleArea(10,10));
    }
    @Test
    void circleArea_radius10(){
        assertEquals(314.15, AreaCalculator.circleArea(10));
    }
    @Test
    void  circleArea_radius3(){
        assertEquals(28.274333882308138, AreaCalculator.circleArea(3));
    }
}
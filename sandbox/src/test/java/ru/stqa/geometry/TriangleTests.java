package ru.stqa.geometry;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ru.stqa.geometry.Triangle.triangleArea;
import static ru.stqa.geometry.Triangle.trianglePerimeter;

public class TriangleTests {
    @Test
    void canCalculateArea() {
        double result = triangleArea(3, 4, 5);
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimeter() {
        double result = trianglePerimeter(3, 4, 5);
        Assertions.assertEquals(12.0, result);
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //ok
        }
    }

    @Test
    void complianceWithTriangleInequality() {

        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Triangle(1.0, 1.0, 3.0);
        });
        Assertions.assertEquals("сумма двух любых сторон должна быть не меньше третьей стороны", thrown.getMessage());

    }

    @Test
    void testEquality() {
        var r1 = new Triangle(5.0, 4.0, 3.0);
        var r2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testEquality2() {
        var r1 = new Triangle(5.0, 4.0, 3.0);
        var r2 = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(r1, r2);
    }

    @Test
    void testEquality4(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(b, c, a);
        Assertions.assertEquals(triangle, triangle1);
    }
}

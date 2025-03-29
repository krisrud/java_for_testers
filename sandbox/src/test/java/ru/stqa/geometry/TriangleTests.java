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
}

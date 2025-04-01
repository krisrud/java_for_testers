package ru.stqa.geometry;

import java.util.Objects;

import static java.lang.Math.sqrt;
import java.util.Arrays;

public record Triangle(double a, double b, double c) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
       /* return Double.compare(a, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(c, triangle.c) == 0
                || Double.compare(b, triangle.a) == 0 && Double.compare(a, triangle.b) == 0 && Double.compare(c, triangle.c) == 0
                || Double.compare(c, triangle.a) == 0 && Double.compare(b, triangle.b) == 0 && Double.compare(a, triangle.c) == 0
                || Double.compare(a, triangle.a) == 0 && Double.compare(c, triangle.b) == 0 && Double.compare(b, triangle.c) == 0;*/
        double[] triangle1 = {a, b, c};
        double[] triangle2 = {triangle.a, triangle.b, triangle.c};
        Arrays.sort(triangle1);
        Arrays.sort(triangle2);
        return Arrays.equals(triangle1, triangle2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    public  Triangle {
        if (a < 0 || b < 0 || c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if (a + b < c || a + c < b || b + c < a) {
            throw new IllegalArgumentException("сумма двух любых сторон должна быть не меньше третьей стороны");
        }
    }

    static void printTrianglePerimeter (double a, double b, double c) {
        System.out.println(String.format("Периметр треугольника со сторонами %f, %f и %f равен %f", a, b, c, trianglePerimeter(a, b, c)));
    }

    public static double trianglePerimeter (double a, double b, double c) {
        return a + b + c;
    }

    static void printTriangleArea (double a, double b, double c) {
        System.out.println(String.format("Площадь треугольника со сторонами %f, %f и %f равна %f", a, b, c, triangleArea(a, b, c)));
    }

    public static double triangleArea (double a, double b, double c) {
        double p = trianglePerimeter(a, b, c) / 2;
        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

}

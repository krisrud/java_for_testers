package ru.stqa.geometry;

import static java.lang.Math.sqrt;

public class Triangle {

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

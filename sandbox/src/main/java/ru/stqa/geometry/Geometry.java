package ru.stqa.geometry;

import static ru.stqa.geometry.Triangle.printTriangleArea;
import static ru.stqa.geometry.Triangle.printTrianglePerimeter;

public class Geometry {
    public static void main(String[] args) {
        printTrianglePerimeter(3, 4, 5);
        printTriangleArea(3, 4, 5);
    }
}

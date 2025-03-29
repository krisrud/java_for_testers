package ru.stqa.geometry;

import java.util.Objects;

public record Rectangle(double a, double b)  {

    public Rectangle {
    if (a < 0 || b < 0) {
        throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(a, rectangle.a) == 0 && Double.compare(b, rectangle.b) == 0
                || Double.compare(b, rectangle.a) == 0 && Double.compare(a, rectangle.b) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }

    public void printRectangleArea(double a, double b) {
       var text = String.format("Площадь прямоугольника со сторонами %f и %f = %f", a, b, rectangleArea(a, b));
       System.out.println(text);
   }

    public double rectangleArea(double a, double b) {
        return a * b;
    }

    public double perimetr(double a, double b) {
        return (2 * this.a + 2*this.b);
    }
}

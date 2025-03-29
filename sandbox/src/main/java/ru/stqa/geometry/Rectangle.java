package ru.stqa.geometry;

public record Rectangle(double a, double b)  {

    public Rectangle {
    if (a < 0 || b < 0) {
        throw new IllegalArgumentException("Rectangle side should be non-negative");
        }
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

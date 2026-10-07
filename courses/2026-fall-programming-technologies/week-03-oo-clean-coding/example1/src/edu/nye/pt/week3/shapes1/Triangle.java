package edu.nye.pt.week3.shapes1;

public final class Triangle extends AbstractPoligon {

    private final Point a;
    private final Point b;
    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double getArea() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(c, a);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(c, a);
        return sideA + sideB + sideC;
    }
}

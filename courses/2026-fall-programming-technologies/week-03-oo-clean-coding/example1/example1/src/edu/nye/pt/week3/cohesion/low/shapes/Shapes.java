package edu.nye.pt.week3.cohesion.low.shapes;

public class Shapes {

    private final Point center;

    private final double radius;

    private final Point a;

    private final Point b;

    private final Point c;

    public Shapes(Point center, double radius, Point a, Point b, Point c) {
        this.center = center;
        this.radius = radius;
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getAreaOfCircle() {
        return Math.PI * radius * radius;
    }

    public double getPerimeterOfCircle() {
        return 2 * Math.PI * radius;
    }

    public double getAreaOfTriangle() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(c, a);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double getPerimeterOfTriangle() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(c, a);
        return sideA + sideB + sideC;
    }

    private double getSide(Point p1, Point p2) {
        double dx = p2.x() - p1.x();
        double dy = p2.y() - p1.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

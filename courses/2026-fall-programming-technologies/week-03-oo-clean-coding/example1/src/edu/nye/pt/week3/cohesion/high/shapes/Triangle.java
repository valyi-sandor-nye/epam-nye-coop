package edu.nye.pt.week3.cohesion.high.shapes;

public class Triangle {

    private final Point a;

    private final Point b;

    private final Point c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getAreaOf() {
        double sideA = getSide(a, b);
        double sideB = getSide(b, c);
        double sideC = getSide(c, a);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double getPerimeterOf() {
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

package edu.nye.pt.week3.shapes3;

public final class Triangle implements ShapeInterface {

    private final Point a;

    private final Point b;

    private final Point c;

    private final HelperInterface helper;

    public Triangle(Point a, Point b, Point c, HelperInterface helper) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.helper = helper;
    }

    @Override
    public double getArea() {
        double sideA = helper.getSide(a, b);
        double sideB = helper.getSide(b, c);
        double sideC = helper.getSide(c, a);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        double sideA = helper.getSide(a, b);
        double sideB = helper.getSide(b, c);
        double sideC = helper.getSide(c, a);
        return sideA + sideB + sideC;
    }

    @Override
    public String getShapeInfo() {
        return helper.formatShape(this);
    }
}
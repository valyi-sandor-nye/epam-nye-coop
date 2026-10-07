package edu.nye.pt.week3.shapes3;

public final class Rectangle implements ShapeInterface {

    private final Point a;

    private final Point b;

    private final Point c;

    private final Point d;

    private final HelperInterface helper;

    public Rectangle(Point a, Point b, Point c, Point d, HelperInterface helper) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.helper = helper;
    }

    @Override
    public double getArea() {
        double width = getWidth();
        double height = getHeight();
        return width * height;
    }

    @Override
    public double getPerimeter() {
        double width = getWidth();
        double height = getHeight();
        return 2 * (width + height);
    }

    @Override
    public String getShapeInfo() {
        return helper.formatShape(this);
    }

    private double getWidth() {
        return helper.getSide(a, b);
    }

    private double getHeight() {
        return helper.getSide(a, c);
    }
}

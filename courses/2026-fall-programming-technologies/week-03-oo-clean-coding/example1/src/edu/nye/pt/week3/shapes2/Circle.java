package edu.nye.pt.week3.shapes2;

public class Circle implements ShapeInterface {

    private final Point center;

    private final double radius;

    private final Helper helper = new Helper();

    public Circle(Point center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getShapeInfo() {
        return helper.formatShape(this);
    }
}

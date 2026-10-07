package edu.nye.pt.week3.shapes3;

public class Circle implements ShapeInterface {

    private final Point center;

    private final double radius;

    private final HelperInterface helper;

    public Circle(Point center, double radius, HelperInterface helper) {
        this.center = center;
        this.radius = radius;
        this.helper = helper;
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

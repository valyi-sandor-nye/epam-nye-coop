package edu.nye.pt.week3.shapes4;

public class Circle implements ShapeInterface {

    private final Point center;

    private final double radius;

    private final ShapeInfoFormatterInterface shapeInfoFormatter;

    public Circle(Point center, double radius, ShapeInfoFormatterInterface shapeInfoFormatter) {
        this.center = center;
        this.radius = radius;
        this.shapeInfoFormatter = shapeInfoFormatter;
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
        return shapeInfoFormatter.formatShape(this);
    }
}

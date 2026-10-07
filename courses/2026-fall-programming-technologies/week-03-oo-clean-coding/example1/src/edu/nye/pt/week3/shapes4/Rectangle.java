package edu.nye.pt.week3.shapes4;

public final class Rectangle implements ShapeInterface {

    private final Point a;

    private final Point b;

    private final Point c;

    private final Point d;

    private final SideCalculatorInterface sideCalculator;

    private final ShapeInfoFormatterInterface shapeInfoFormatter;

    public Rectangle(Point a, Point b, Point c, Point d,
                     SideCalculatorInterface sideCalculator, ShapeInfoFormatterInterface shapeInfoFormatter) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.sideCalculator = sideCalculator;
        this.shapeInfoFormatter = shapeInfoFormatter;
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
        return shapeInfoFormatter.formatShape(this);
    }

    private double getWidth() {
        return sideCalculator.getSide(a, b);
    }

    private double getHeight() {
        return sideCalculator.getSide(a, c);
    }
}

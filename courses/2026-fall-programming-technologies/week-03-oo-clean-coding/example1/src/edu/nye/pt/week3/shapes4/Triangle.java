package edu.nye.pt.week3.shapes4;

public final class Triangle implements ShapeInterface {

    private final Point a;

    private final Point b;

    private final Point c;

    private final SideCalculatorInterface sideCalculator;

    private final ShapeInfoFormatterInterface shapeInfoFormatter;

    public Triangle(Point a, Point b, Point c, SideCalculatorInterface sideCalculator, ShapeInfoFormatterInterface shapeInfoFormatter) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.sideCalculator = sideCalculator;
        this.shapeInfoFormatter = shapeInfoFormatter;
    }

    @Override
    public double getArea() {
        double sideA = sideCalculator.getSide(a, b);
        double sideB = sideCalculator.getSide(b, c);
        double sideC = sideCalculator.getSide(c, a);
        double s = (sideA + sideB + sideC) / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public double getPerimeter() {
        double sideA = sideCalculator.getSide(a, b);
        double sideB = sideCalculator.getSide(b, c);
        double sideC = sideCalculator.getSide(c, a);
        return sideA + sideB + sideC;
    }

    @Override
    public String getShapeInfo() {
        return shapeInfoFormatter.formatShape(this);
    }
}
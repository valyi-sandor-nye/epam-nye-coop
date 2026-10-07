package edu.nye.pt.week3.shapes1;

public final class Rectangle extends AbstractPoligon {

    private final Point a;

    private final Point b;

    private final Point c;

    private final Point d;

    public Rectangle(Point a, Point b, Point c, Point d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
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

    private double getWidth() {
        return getSide(a, b);
    }

    private double getHeight() {
        return getSide(a, c);
    }
}

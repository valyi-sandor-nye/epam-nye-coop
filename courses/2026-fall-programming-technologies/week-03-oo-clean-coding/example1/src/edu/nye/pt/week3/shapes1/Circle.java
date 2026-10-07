package edu.nye.pt.week3.shapes1;

public final class Circle extends AbstractShape {

    private final Point center;
    private final double radius;

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
        return  """
                 %s area: %s
                 %s perimeter (2*r*π): %s
                """.formatted(getClass().getSimpleName(), getArea(), getClass().getSimpleName(), getPerimeter());
    }
}

package edu.nye.pt.week3.shapes1;

public abstract class AbstractPoligon extends AbstractShape {

    protected double getSide(Point p1, Point p2) {
        double dx = p2.x() - p1.x();
        double dy = p2.y() - p1.y();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String getShapeInfo() {
        return """
                 %s area: %s
                 %s perimeter (the sum of its sides): %s
                """.formatted(getClass().getSimpleName(), getArea(), getClass().getSimpleName(), getPerimeter());
    }
}

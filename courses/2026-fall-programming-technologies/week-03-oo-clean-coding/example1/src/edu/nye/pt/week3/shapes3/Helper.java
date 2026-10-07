package edu.nye.pt.week3.shapes3;

public class Helper implements HelperInterface {

    @Override
    public final String formatShape(ShapeInterface shape) {
        return """
                 %s area: %s
                 %s perimeter: %s
                """.formatted(shape.getClass().getSimpleName(), shape.getArea(), shape.getClass().getSimpleName(), shape.getPerimeter());
    }

    @Override
    public final double getSide(Point p1, Point p2) {
        double dx = p2.x() - p1.x();
        double dy = p2.y() - p1.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

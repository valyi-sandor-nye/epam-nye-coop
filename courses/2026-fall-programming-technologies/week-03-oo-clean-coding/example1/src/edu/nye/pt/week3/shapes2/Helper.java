package edu.nye.pt.week3.shapes2;

public final class Helper {

    public String formatShape(ShapeInterface shape) {
        return """
                 %s area: %s
                 %s perimeter: %s
                """.formatted(shape.getClass().getSimpleName(), shape.getArea(), shape.getClass().getSimpleName(), shape.getPerimeter());
    }

    public double getSide(Point p1, Point p2) {
        double dx = p2.x() - p1.x();
        double dy = p2.y() - p1.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

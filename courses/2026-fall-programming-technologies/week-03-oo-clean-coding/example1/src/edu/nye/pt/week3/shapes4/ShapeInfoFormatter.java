package edu.nye.pt.week3.shapes4;

public class ShapeInfoFormatter implements ShapeInfoFormatterInterface {

    public String formatShape(ShapeInterface shape) {
        return """
                 %s area: %s
                 %s perimeter: %s
                """.formatted(shape.getClass().getSimpleName(), shape.getArea(), shape.getClass().getSimpleName(), shape.getPerimeter());
    }
}

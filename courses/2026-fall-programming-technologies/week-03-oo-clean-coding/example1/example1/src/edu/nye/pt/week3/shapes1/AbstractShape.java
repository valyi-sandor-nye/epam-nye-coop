package edu.nye.pt.week3.shapes1;

public abstract class AbstractShape {

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getShapeInfo() {
        return """
                 %s area: %s
                 %s perimeter: %s
                """.formatted(getClass().getSimpleName(), getArea(), getClass().getSimpleName(), getPerimeter());
    }
}

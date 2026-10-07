package edu.nye.pt.week3.shapes1;

public class Main {

    static void main(String[] args) {
        printShapeInfo(getCircle());
        printShapeInfo(getTriangle());
        printShapeInfo(getRectangle());
    }

    private static Circle getCircle() {
        Point p1 = new Point(0, 0);
        return new Circle(p1, 5);
    }

    private static Triangle getTriangle() {
        Point p2 = new Point(0, 0);
        Point p3 = new Point(3, 4);
        Point p4 = new Point(6, 0);
        return new Triangle(p2, p3, p4);
    }

    private static Rectangle getRectangle() {
        Point p5 = new Point(0, 0);
        Point p6 = new Point(4, 0);
        Point p7 = new Point(4, 3);
        Point p8 = new Point(0, 3);
        return new Rectangle(p5, p6, p7, p8);
    }

    private static void printShapeInfo(AbstractShape shape) {
        System.out.println(shape.getShapeInfo());
    }
}

package edu.nye.pt.week3.shapes4;

public class SideCalculator implements SideCalculatorInterface {

    @Override
    public double getSide(Point p1, Point p2) {
        double dx = p2.x() - p1.x();
        double dy = p2.y() - p1.y();
        return Math.sqrt(dx * dx + dy * dy);
    }
}

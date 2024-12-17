package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {
    public List<Shape> shapes = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapes.add(shape);
    }

    public void removeFigure(Shape shape) {
        shapes.remove(shape);
    }

    public Shape getFigure(int n) {
        return shapes.get(n);
    }

    public String showFigures() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shapes.size(); i++) {
            sb.append(shapes.get(i).getShapeName());
            if (i < shapes.size() - 1) {
                sb.append(", ");
            } else sb.append(".");
        }
        return sb.toString();
    }

    public List<Shape> getShapes() {
        return shapes;
    }

}

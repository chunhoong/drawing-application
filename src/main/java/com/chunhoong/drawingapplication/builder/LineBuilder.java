package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Line;

public class LineBuilder {

    private int x1, y1;
    private int x2, y2;

    public LineBuilder point1(String x, String y) {
        this.x1 = Integer.parseInt(x) - 1;
        this.y1 = Integer.parseInt(y) - 1;
        return this;
    }

    public LineBuilder point2(String x, String y) {
        this.x2 = Integer.parseInt(x) - 1;
        this.y2 = Integer.parseInt(y) - 1;
        return this;
    }

    public Line build() {
        Line line = new Line();
        line.setX1(x1);
        line.setY1(y1);
        line.setX2(x2);
        line.setY2(y2);
        return line;
    }

}
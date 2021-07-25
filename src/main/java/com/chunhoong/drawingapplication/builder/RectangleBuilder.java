package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Rectangle;

public class RectangleBuilder {
    private int xTopLeft, yTopLeft;
    private int xBottomRight, yBottomRight;

    public RectangleBuilder topLeft(String x, String y) {
        this.xTopLeft = Integer.parseInt(x) - 1;
        this.yTopLeft = Integer.parseInt(y) - 1;
        return this;
    }

    public RectangleBuilder bottomRight(String x, String y) {
        this.xBottomRight = Integer.parseInt(x) - 1;
        this.yBottomRight = Integer.parseInt(y) -1;
        return this;
    }

    public Rectangle build() {
        Rectangle rectangle = new Rectangle();
        rectangle.setXTopLeft(xTopLeft);
        rectangle.setYTopLeft(yTopLeft);
        rectangle.setXBottomRight(xBottomRight);
        rectangle.setYBottomRight(yBottomRight);
        return rectangle;
    }
}

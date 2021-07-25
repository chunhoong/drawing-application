package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Canvas;

public class CanvasBuilder {

    private int width, height;

    public CanvasBuilder width(String width) {
        this.width = Integer.parseInt(width);
        return this;
    }

    public CanvasBuilder height(String height) {
        this.height = Integer.parseInt(height);
        return this;
    }

    public Canvas build() {
        return new Canvas(width, height);
    }

}

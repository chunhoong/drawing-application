package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Shade;

public class ShadeBuilder {
    private int x, y;
    private String color;

    public ShadeBuilder point(String x, String y) {
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        return this;
    }

    public ShadeBuilder color(String color) {
        this.color = color;
        return this;
    }

    public Shade build() {
        Shade shade = new Shade();
        shade.setX(x);
        shade.setY(y);
        shade.setColor(color);
        return shade;
    }

}
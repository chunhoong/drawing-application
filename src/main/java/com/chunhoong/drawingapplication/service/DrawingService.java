package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Graphic;

public interface DrawingService<T extends Graphic> {

    default String getPattern() {
        return "x";
    }

    void draw(T t);

}

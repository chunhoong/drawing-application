package com.chunhoong.drawingapplication.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Line extends Graphic {

    private int x1, y1;
    private int x2, y2;

}

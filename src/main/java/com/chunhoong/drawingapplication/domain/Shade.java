package com.chunhoong.drawingapplication.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Shade extends Graphic {

    private int x, y;
    private String color;

}

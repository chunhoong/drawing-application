package com.chunhoong.drawingapplication.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class Rectangle extends Graphic  {

    private int xTopLeft, yTopLeft;
    private int xBottomRight, yBottomRight;

}

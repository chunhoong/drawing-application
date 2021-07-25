package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleBuilderTest {

    @Test
    public void test() {
        Rectangle rectangle = new RectangleBuilder()
                .topLeft("1", "3")
                .bottomRight("8", "10")
                .build();

        assertEquals(1,rectangle.getXTopLeft());
        assertEquals(3, rectangle.getYTopLeft());
        assertEquals(8, rectangle.getXBottomRight());
        assertEquals(10, rectangle.getYBottomRight());
    }

}
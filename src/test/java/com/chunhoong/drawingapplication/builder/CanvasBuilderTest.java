package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Canvas;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanvasBuilderTest {

    @Test
    public void test() {
        Canvas canvas = new CanvasBuilder()
                .width("10")
                .height("5")
                .build();
        assertEquals(10, canvas.getWidth());
        assertEquals(5, canvas.getHeight());
    }

}
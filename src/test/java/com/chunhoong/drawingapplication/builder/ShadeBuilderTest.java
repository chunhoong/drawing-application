package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Shade;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShadeBuilderTest {

    @Test
    public void test() {
        Shade shade = new ShadeBuilder()
                .point("1", "3")
                .color("g")
                .build();
        assertEquals(1, shade.getX());
        assertEquals(3, shade.getY());
        assertEquals("g", shade.getColor());
    }
}
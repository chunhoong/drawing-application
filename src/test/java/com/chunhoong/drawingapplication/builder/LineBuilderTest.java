package com.chunhoong.drawingapplication.builder;

import com.chunhoong.drawingapplication.domain.Line;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LineBuilderTest {

    @Test
    public void test() {
        Line line = new LineBuilder()
                .point1("1", "2")
                .point2("1", "3")
                .build();
        assertEquals(1, line.getX1());
        assertEquals(2, line.getY1());
        assertEquals(1, line.getX2());
        assertEquals(3, line.getY2());
    }

}
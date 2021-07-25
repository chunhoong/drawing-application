package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.builder.CanvasBuilder;
import com.chunhoong.drawingapplication.builder.LineBuilder;
import com.chunhoong.drawingapplication.domain.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(OutputCaptureExtension.class)
class LineDrawingServiceTest {

    private LineDrawingService lineDrawingService;

    @BeforeEach
    public void init() {
        CanvasService canvasService = new CanvasService();
        canvasService.initCanvas(new CanvasBuilder().width("10").height("10").build());
        lineDrawingService = new LineDrawingService(canvasService);
    }

    @Test
    public void testNonHorizontalNonVerticalLine(CapturedOutput output) {
        Line line = new LineBuilder()
                .point1("1", "2")
                .point2("2", "3")
                .build();
        lineDrawingService.draw(line);
        assertEquals("Only vertical or horizontal line is supported\r\n", output.getOut());
    }

}
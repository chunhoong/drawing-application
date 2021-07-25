package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.builder.CanvasBuilder;
import com.chunhoong.drawingapplication.domain.Canvas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(OutputCaptureExtension.class)
class CanvasServiceTest {


    private CanvasService canvasService;

    @BeforeEach
    public void init() {
        canvasService = new CanvasService();
    }

    @Test
    public void testInitCanvas() {
        Canvas sourceCanvas = new CanvasBuilder()
                .width("10")
                .height("10")
                .build();
        canvasService.initCanvas(sourceCanvas);
        Canvas canvas = (Canvas) ReflectionTestUtils.getField(canvasService, "canvas");
        assertEquals(sourceCanvas, canvas);
    }

    @Test
    public void testGetCanvas() {
        Canvas sourceCanvas = new CanvasBuilder()
                .width("10")
                .height("10")
                .build();
        canvasService.initCanvas(sourceCanvas);
        assertEquals(sourceCanvas, canvasService.getCanvas());
    }

    @Test
    public void testPrint(CapturedOutput output) {
        Canvas sourceCanvas = new CanvasBuilder()
                .width("10")
                .height("5")
                .build();
        canvasService.initCanvas(sourceCanvas);
        canvasService.printCanvas();
        assertTrue(output.getOut().startsWith("------------\r\n"));
        assertTrue(output.getOut().endsWith("------------\r\n"));
    }

}
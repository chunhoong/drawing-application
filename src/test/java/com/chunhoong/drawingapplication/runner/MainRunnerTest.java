package com.chunhoong.drawingapplication.runner;

import com.chunhoong.drawingapplication.facade.DrawingFacade;
import com.chunhoong.drawingapplication.service.InputUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MainRunnerTest {

    private InputUtil inputUtil;
    private DrawingFacade drawingFacade;
    private MainRunner mainRunner;

    @BeforeEach
    public void init() {
        inputUtil = mock(InputUtil.class);
        drawingFacade = mock(DrawingFacade.class);
        mainRunner = new MainRunner(inputUtil, drawingFacade);
    }

    @Test
    public void testQuit() throws Exception {
        when(inputUtil.readInput(any())).thenReturn("Q");
        mainRunner.run();
        Boolean isExiting = ReflectionTestUtils.invokeMethod(mainRunner, "isExiting");
        assertTrue(isExiting != null && isExiting);
    }

    @Test
    public void testCreateCanvas() throws Exception {
        when(inputUtil.readInput(any())).thenReturn("C 20 4", "Q");
        mainRunner.run();
        verify(drawingFacade).initCanvas(any());
    }

    @Test
    public void testDrawLine() throws Exception {
        when(inputUtil.readInput(any())).thenReturn("L 1 2 6 2", "Q");
        mainRunner.run();
        verify(drawingFacade).drawLine(any());
    }

    @Test
    public void testDrawRectangle() throws Exception {
        when(inputUtil.readInput(any())).thenReturn("R 14 1 18 3", "Q");
        mainRunner.run();
        verify(drawingFacade).drawRectangle(any());
    }

    @Test
    public void testDrawShade() throws Exception {
        when(inputUtil.readInput(any())).thenReturn("B 10 3 o", "Q");
        mainRunner.run();
        verify(drawingFacade).drawShade(any());
    }

}
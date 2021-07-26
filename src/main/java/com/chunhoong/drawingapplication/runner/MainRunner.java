package com.chunhoong.drawingapplication.runner;

import com.chunhoong.drawingapplication.builder.CanvasBuilder;
import com.chunhoong.drawingapplication.builder.LineBuilder;
import com.chunhoong.drawingapplication.builder.RectangleBuilder;
import com.chunhoong.drawingapplication.builder.ShadeBuilder;
import com.chunhoong.drawingapplication.domain.Canvas;
import com.chunhoong.drawingapplication.domain.Line;
import com.chunhoong.drawingapplication.domain.Rectangle;
import com.chunhoong.drawingapplication.domain.Shade;
import com.chunhoong.drawingapplication.facade.DrawingFacade;
import com.chunhoong.drawingapplication.util.InputUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MainRunner implements CommandLineRunner {

    private String input;
    private String[] inputValues;
    private final InputUtil inputUtil;
    private final DrawingFacade drawingFacade;

    @Autowired
    public MainRunner(InputUtil inputUtil, DrawingFacade drawingFacade) {
        this.inputUtil = inputUtil;
        this.drawingFacade = drawingFacade;
    }

    @Override
    public void run(String... args) throws Exception {
        while (!isExiting()) {
            readInput();

            if (isCreatingCanvas()) {
                Canvas canvas = new CanvasBuilder()
                        .width(inputValues[1])
                        .height(inputValues[2])
                        .build();
               drawingFacade.initCanvas(canvas);
               drawingFacade.printCanvas();
            } else if (isDrawingLine()) {
                Line line = new LineBuilder()
                        .point1(inputValues[1], inputValues[2])
                        .point2(inputValues[3], inputValues[4])
                        .build();
                drawingFacade.drawLine(line);
                drawingFacade.printCanvas();
            } else if (isDrawingRectangle()) {
                Rectangle rectangle = new RectangleBuilder()
                        .topLeft(inputValues[1], inputValues[2])
                        .bottomRight(inputValues[3], inputValues[4])
                        .build();
                drawingFacade.drawRectangle(rectangle);
                drawingFacade.printCanvas();
            } else if (isShading()) {
                Shade shade = new ShadeBuilder()
                        .point(inputValues[1], inputValues[2])
                        .color(inputValues[3])
                        .build();
                drawingFacade.drawShade(shade);
                drawingFacade.printCanvas();
            }
        }
    }

    public void readInput() {
        input = inputUtil.readInput("enter command: ");
        inputValues = input.split(" ");
    }

    private boolean isCreatingCanvas() {
        if (inputValues.length != 3) {
            return false;
        }

        if (!"C".equals(inputValues[0])) {
            return false;
        }

        try {
            Integer.parseInt(inputValues[1]);
            Integer.parseInt(inputValues[2]);
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    private boolean isDrawingLine() {
        if (inputValues.length != 5) {
            return false;
        }

        if (!"L".equals(inputValues[0])) {
            return false;
        }

        try {
            Integer.parseInt(inputValues[1]);
            Integer.parseInt(inputValues[2]);
            Integer.parseInt(inputValues[3]);
            Integer.parseInt(inputValues[4]);
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    private boolean isDrawingRectangle() {
        if (inputValues.length != 5) {
            return false;
        }

        if (!"R".equals(inputValues[0])) {
            return false;
        }

        try {
            Integer.parseInt(inputValues[1]);
            Integer.parseInt(inputValues[2]);
            Integer.parseInt(inputValues[3]);
            Integer.parseInt(inputValues[4]);
        } catch (NumberFormatException exception) {
            return false;
        }

        return true;
    }

    private boolean isShading() {
        if (inputValues.length != 4) {
            return false;
        }

        if (!"B".equals(inputValues[0])) {
            return false;
        }

        try {
            Integer.parseInt(inputValues[1]);
            Integer.parseInt(inputValues[2]);
        } catch (NumberFormatException exception) {
            return false;
        }

        return inputValues[3] != null && inputValues[3].length() == 1;
    }

    private boolean isExiting() {
        return "Q".equals(input);
    }

}

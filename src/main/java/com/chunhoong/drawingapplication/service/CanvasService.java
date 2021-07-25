package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Canvas;
import org.springframework.stereotype.Service;

@Service
public class CanvasService {

    private Canvas canvas;

    public void initCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void printCanvas() {
        var pixels = canvas.getPixels();
        var rowCounter = 0;
        while (rowCounter < pixels.size()) {
            String row = String.join("", pixels.get(rowCounter));
            System.out.println(row);
            rowCounter++;
        }
    }
}

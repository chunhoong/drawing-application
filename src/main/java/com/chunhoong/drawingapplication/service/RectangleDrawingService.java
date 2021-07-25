package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RectangleDrawingService implements DrawingService<Rectangle> {
    private final CanvasService canvasService;

    @Autowired
    public RectangleDrawingService(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @Override
    public void draw(Rectangle rectangle) {
        var pixels = canvasService.getCanvas().getPixels();
        var xTopLeft = rectangle.getXTopLeft();
        var yTopLeft = rectangle.getYTopLeft();
        var xBottomRight = rectangle.getXBottomRight();
        var yBottomRight = rectangle.getYBottomRight();

        if (xTopLeft == xBottomRight || yTopLeft == yBottomRight) {
            System.out.println("Invalid coordinates for a rectangle");
            return;
        }

        for (int j = yTopLeft; j <= yBottomRight; j++) {
            if (j == yTopLeft || j == yBottomRight) {
                for (int i = xTopLeft; i <= xBottomRight; i++) {
                    pixels.get(j).set(i, getPattern());
                }
            } else {
                pixels.get(j).set(xTopLeft, getPattern());
                pixels.get(j).set(xBottomRight, getPattern());
            }
        }
    }
}

package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Shade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Service
public class ShadeDrawingService implements DrawingService<Shade>{
    private static final Logger logger = LoggerFactory.getLogger(ShadeDrawingService.class);
    private final CanvasService canvasService;

    @Autowired
    public ShadeDrawingService(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @Override
    public void draw(Shade shade) {
        var x = shade.getX();
        var y = shade.getY();
        var color = shade.getColor();
        doShade(x, y, color);
    }

    public void doShade(int x, int y, String color) {
        var width = canvasService.getCanvas().getWidth();
        var height = canvasService.getCanvas().getHeight();
        var pixels = canvasService.getCanvas().getPixels();
        var linePattern = getPattern();

        Consumer<Integer> shadeAndLocate = i -> {
            pixels.get(y).set(i, color);
            boolean isUpperPixelWithinCanvas  = y - 1 >= 1;
            boolean isBottomPixelWithinCanvas = y + 1 <= height;

            if (isUpperPixelWithinCanvas) {
                String upperPixel = pixels.get(y - 1).get(i);
                if (!isShadedOrLine(upperPixel, color)) {
                    doShade(i, y - 1, color);
                }
            }

            if (isBottomPixelWithinCanvas) {
                String bottomPixel = pixels.get(y + 1).get(i);
                if (!isShadedOrLine(bottomPixel, color)) {
                    doShade(i, y + 1, color);
                }
            }
        };

        for (int i = x; i <= width; i++) {
            String pixel = pixels.get(y).get(i);
            if (isShadedOrLine(pixel, color)) {
                break;
            } else {
                shadeAndLocate.accept(i);
            }
        }

        for (int i = x - 1; i >= 1; i--) {
            String pixel = pixels.get(y).get(i);
            if (isShadedOrLine(pixel, color)) {
                break;
            } else {
                shadeAndLocate.accept(i);
            }
        }
    }

    private boolean isShadedOrLine(String pixel, String color) {
        return color.equals(pixel) || getPattern().equals(pixel);
    }
}

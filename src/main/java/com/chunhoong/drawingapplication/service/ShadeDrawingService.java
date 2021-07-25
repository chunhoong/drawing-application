package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Shade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        for (int i = x; i < width; i++) {
            if (linePattern.equals(pixels.get(y).get(i))) {
                break;
            } else if (color.equals(pixels.get(y).get(i))) {
                break;
            } else {
                pixels.get(y).set(i, color);
                boolean isUpperPixelWithinCanvas  = y - 1 >= 0;
                boolean isBottomPixelWithinCanvas = y + 1 < height;

                if (isUpperPixelWithinCanvas) {
                    logger.info("Otw to right and upper pixel within canvas. x: {}, y: {}", i, y - 1);
                    String upperPixel = pixels.get(y - 1).get(i);
                    if (isNotShadedAndNotLine(upperPixel, color)) {
                        doShade(i, y - 1, color);
                    }
                }

                if (isBottomPixelWithinCanvas) {
                    logger.info("Otw to right and bottom pixel within canvas. x: {}, y: {}", i, y + 1);
                    String bottomPixel = pixels.get(y + 1).get(i);
                    if (isNotShadedAndNotLine(bottomPixel, color)) {
                        doShade(i, y + 1, color);
                    }
                }
            }
        }

        for (int i = x - 1; i >= 0; i--) {
            if (linePattern.equals(pixels.get(y).get(i))) {
                break;
            } else if (color.equals(pixels.get(y).get(i))) {
                break;
            } else {
                pixels.get(y).set(i, color);
                boolean isUpperPixelWithinCanvas  = y - 1 >= 0;
                boolean isBottomPixelWithinCanvas = y + 1 < height;

                if (isUpperPixelWithinCanvas) {
                    logger.info("Otw to left and upper pixel within canvas. x: {}, y: {}", i, y - 1);
                    String bottomPixel = pixels.get(y - 1).get(i);
                    if (isNotShadedAndNotLine(bottomPixel, color)) {
                        doShade(i, y - 1, color);
                    }
                }

                if (isBottomPixelWithinCanvas) {
                    logger.info("Otw to left and lower pixel within canvas. x: {}, y: {}", i, y + 1);
                    String bottomPixel = pixels.get(y + 1).get(i);
                    if (isNotShadedAndNotLine(bottomPixel, color)) {
                        doShade(i, y + 1, color);
                    }
                }
            }
        }
    }

    private boolean isNotShadedAndNotLine(String pixel, String color) {
        return !color.equals(pixel) && !color.equals(getPattern());
    }
}

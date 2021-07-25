package com.chunhoong.drawingapplication.service;

import com.chunhoong.drawingapplication.domain.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineDrawingService implements DrawingService<Line> {
    private final CanvasService canvasService;

    @Autowired
    public LineDrawingService(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @Override
    public void draw(Line line) {
        var pixels = canvasService.getCanvas().getPixels();
        var x1 = line.getX1();
        var y1 = line.getY1();
        var x2 = line.getX2();
        var y2 = line.getY2();
        if (isDrawingVerticalLine(line)) {
            if (y2 > y1) {
                for (int i = y1; i <= y2; i++) {
                    pixels.get(i).set(x1, getPattern());
                }
            } else if (y1 > y2) {
                for (int i = y2; i <= y1; i++) {
                    pixels.get(i).set(x1, getPattern());
                }
            }
        } else if (isDrawingHorizontalLine(line)) {
            List<String> row = pixels.get(y1);
            if (x2 > x1) {
                for (int i = x1; i <= x2; i++) {
                    row.set(i, getPattern());
                }
            } else if (x1 > x2) {
                for (int i = x2; i <= x1; i++) {
                    row.set(i, getPattern());
                }
            }
            pixels.set(y1, row);
        } else {
            System.out.println("Only vertical or horizontal line is supported");
        }
    }

    private boolean isDrawingVerticalLine(Line line) {
        return line.getX1() == line.getX2();
    }

    private boolean isDrawingHorizontalLine(Line line) {
        return line.getY1() == line.getY2();
    }

}

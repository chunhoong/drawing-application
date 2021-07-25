package com.chunhoong.drawingapplication.facade;

import com.chunhoong.drawingapplication.domain.Canvas;
import com.chunhoong.drawingapplication.domain.Line;
import com.chunhoong.drawingapplication.domain.Rectangle;
import com.chunhoong.drawingapplication.domain.Shade;
import com.chunhoong.drawingapplication.service.CanvasService;
import com.chunhoong.drawingapplication.service.LineDrawingService;
import com.chunhoong.drawingapplication.service.RectangleDrawingService;
import com.chunhoong.drawingapplication.service.ShadeDrawingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DrawingFacade {

    private final CanvasService canvasService;
    private final LineDrawingService lineDrawingService;
    private final RectangleDrawingService rectangleDrawingService;
    private final ShadeDrawingService shadeDrawingService;

    @Autowired
    public DrawingFacade(CanvasService canvasService, LineDrawingService lineDrawingService, RectangleDrawingService rectangleDrawingService,
                         ShadeDrawingService shadeDrawingService) {
        this.canvasService = canvasService;
        this.lineDrawingService = lineDrawingService;
        this.rectangleDrawingService = rectangleDrawingService;
        this.shadeDrawingService = shadeDrawingService;
    }

    public void initCanvas(Canvas canvas) {
        canvasService.initCanvas(canvas);
    }

    public void printCanvas() {
        canvasService.printCanvas();
    }

    public void drawLine(Line line) {
        lineDrawingService.draw(line);
    }

    public void drawRectangle(Rectangle rectangle) {
        rectangleDrawingService.draw(rectangle);
    }

    public void drawShade(Shade shade) {
        shadeDrawingService.draw(shade);
    }

}

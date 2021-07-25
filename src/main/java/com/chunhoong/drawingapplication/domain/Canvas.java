package com.chunhoong.drawingapplication.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Canvas {

    private static final String BACKGROUND_PIXEL = " ";
    private int width, height;
    private List<List<String>> pixels = new ArrayList<>();

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        createBlankCanvas();
    }

    private void createBlankCanvas() {
        pixels = new ArrayList<>();
        int rowCounter = 0;
        while (rowCounter <= height + 1) {
            List<String> row = new ArrayList<>();
            int columnCounter = 0;

            // Print upper and lower border
            if (rowCounter == 0 || rowCounter == height + 1) {
                while (columnCounter <= width + 1) {
                    row.add("-");
                    columnCounter++;
                }
            } else {
                while (columnCounter <= width + 1) {
                    var isVerticalBorder = columnCounter == 0 || columnCounter == width + 1;
                    row.add(isVerticalBorder ? "|" : BACKGROUND_PIXEL);
                    columnCounter++;
                }
            }


            pixels.add(row);

            rowCounter++;
        }
    }
}

package com.chunhoong.drawingapplication.domain;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Canvas {

    private int width, height;
    private List<List<String>> pixels = new ArrayList<>();
    private static final String BACKGROUND_PIXEL = " ";

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        createBlankCanvas();
    }



    private void createBlankCanvas() {
        pixels = new ArrayList<>();
        int rowCounter = 0;
        while (rowCounter < height) {
            int columnCounter = 0;

            List<String> row = new ArrayList<>();
            while (columnCounter < width) {
                row.add(BACKGROUND_PIXEL);
                columnCounter++;
            }

            pixels.add(row);

            rowCounter++;
        }
    }
}

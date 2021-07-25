package com.chunhoong.drawingapplication.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Component
public class InputUtil {

    public String readInput(String instruction) {
        System.out.print(instruction);
        return new Scanner(System.in).nextLine();
    }
}

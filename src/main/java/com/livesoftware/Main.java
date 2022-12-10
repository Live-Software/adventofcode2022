package com.livesoftware;

import com.livesoftware.days.day9.Day9XSolution;
import com.livesoftware.days.day9.RopeMovementInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new RopeMovementInputMapper();
        var solution = new Day9XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day9");
        System.out.println(result);
    }
}
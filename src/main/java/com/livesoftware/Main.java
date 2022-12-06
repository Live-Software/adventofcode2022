package com.livesoftware;

import com.livesoftware.days.day5.Day5XSolution;
import com.livesoftware.days.day5.StackerInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new StackerInputMapper();
        var solution = new Day5XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day5");
        System.out.println(result);
    }
}
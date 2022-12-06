package com.livesoftware;

import com.livesoftware.days.day5.StackerInputMapper;
import com.livesoftware.days.day6.Day6XSolution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new StackerInputMapper();
        var solution = new Day6XSolution();
        var solver = new DaySolver<>(fileInputReader, s -> s, solution);
        var result = solver.solveDay("src/main/resources/day6");
        System.out.println(result);
    }
}
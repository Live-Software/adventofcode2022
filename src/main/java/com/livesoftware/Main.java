package com.livesoftware;

import com.livesoftware.days.day8.Day8XSolution;
import com.livesoftware.days.day8.IntListListInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new IntListListInputMapper();
        var solution = new Day8XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day8");
        System.out.println(result);
    }
}
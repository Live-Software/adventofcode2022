package com.livesoftware;

import com.livesoftware.days.day12.CharToIntListListInputMapper;
import com.livesoftware.days.day12.Day12XSolution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new CharToIntListListInputMapper();
        var solution = new Day12XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day12");
        System.out.println(result);
    }
}
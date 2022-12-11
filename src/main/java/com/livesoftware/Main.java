package com.livesoftware;

import com.livesoftware.days.day11.Day11XSolution;
import com.livesoftware.days.day11.MonkeyInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new MonkeyInputMapper();
        var solution = new Day11XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day11");
        System.out.println(result);
    }
}
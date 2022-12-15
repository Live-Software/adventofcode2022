package com.livesoftware;

import com.livesoftware.days.day14.CaveInputReader;
import com.livesoftware.days.day14.Day14Solution;
import com.livesoftware.days.day14.Day14XSolution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new CaveInputReader();
        var solution = new Day14XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day14");
        System.out.println(result);
    }
}
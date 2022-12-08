package com.livesoftware;

import com.livesoftware.days.day7.Day7XSolution;
import com.livesoftware.days.day7.DirectoryInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new DirectoryInputMapper();
        var solution = new Day7XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day7");
        System.out.println(result);
    }
}
package com.livesoftware;

import com.livesoftware.days.day10.CommandInputMapper;
import com.livesoftware.days.day10.Day10Solution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new CommandInputMapper();
        var solution = new Day10Solution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day10");
        System.out.println(result);
    }
}
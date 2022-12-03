package com.livesoftware;

import com.livesoftware.days.day3.Day3Solution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var solution = new Day3Solution();
        var solver = new DaySolver<>(fileInputReader, s -> s, solution);
        var result = solver.solveDay("src/main/resources/day3");
        System.out.println(result);
    }
}
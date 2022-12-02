package com.livesoftware;

import com.livesoftware.days.day2.Day2Solution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var solution = new Day2Solution();
        var solver = new DaySolver<>(fileInputReader, s -> s, solution);
        var result = solver.solveDay("/home/akster/Projects/adventofcode2022/src/main/resources/day2");
        System.out.println(result);
    }
}
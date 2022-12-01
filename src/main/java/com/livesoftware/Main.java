package com.livesoftware;

import com.livesoftware.days.day1.Day1XSolution;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var solution = new Day1XSolution();
        var solver = new DaySolver<>(fileInputReader, s -> s, solution);
        var result = solver.solveDay("/home/akster/IdeaProjects/adventofcode2022/src/main/resources/day1");
        System.out.println(result);
    }
}
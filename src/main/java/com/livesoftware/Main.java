package com.livesoftware;

import com.livesoftware.days.day15.Day15XSolution;
import com.livesoftware.days.day15.SensorBeaconInputMapper;
import com.livesoftware.input.FileInputReader;
import com.livesoftware.solver.DaySolver;

public class Main {

    public static void main(String[] args) {
        var fileInputReader = new FileInputReader();
        var inputMapper = new SensorBeaconInputMapper();
        var solution = new Day15XSolution();
        var solver = new DaySolver<>(fileInputReader, inputMapper, solution);
        var result = solver.solveDay("src/main/resources/day15");
        System.out.println(result);
    }
}
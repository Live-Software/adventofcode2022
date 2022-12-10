package com.livesoftware.days.day10;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.List;

public class Day10Solution implements Solution<List<Pair<Command, Integer>>> {

    @Override
    public String solve(List<Pair<Command, Integer>> input) {
        int checkIndex = 0;
        int register = 1;
        List<Integer> checks = List.of(20, 60, 100, 140, 180, 220);
        int sum = 0;
        int cycle = 0;
        for (var line : input) {
            switch (line.getFirst()) {
                case noop -> {
                    cycle++;
                    if (checks.contains(cycle)) {
                        sum += register * cycle;
                    }
                }
                case addx -> {
                    cycle++;
                    if (checks.contains(cycle)) {
                        sum += register * cycle;
                    }
                    cycle++;
                    if (checks.contains(cycle)) {
                        sum += register * cycle;
                    }
                    register += line.getSecond();
                }
            }
        }
        return "" + sum;
    }
}

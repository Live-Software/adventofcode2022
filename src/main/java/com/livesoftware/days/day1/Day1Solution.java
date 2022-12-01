package com.livesoftware.days.day1;

import com.livesoftware.solver.Solution;

import java.util.List;

public class Day1Solution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        int max = 0;
        int current = 0;
        for (String line : input) {
            if (line.isEmpty()) {
                if (current > max) {
                    max = current;
                }
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }
        if (current > max) {
            max = current;
        }
        return "" + max;
    }
}

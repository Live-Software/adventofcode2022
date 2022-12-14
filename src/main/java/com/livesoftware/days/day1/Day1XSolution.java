package com.livesoftware.days.day1;

import com.livesoftware.solver.Solution;

import java.util.List;

public class Day1XSolution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int current = 0;
        for (String line : input) {
            if (line.isEmpty()) {
                if (current > max1) {
                    max3 = max2;
                    max2 = max1;
                    max1 = current;

                } else if (current > max2) {
                    max3 = max2;
                    max2 = current;
                } else if (current > max3) {
                    max3 = current;
                }
                current = 0;
            } else {
                current += Integer.parseInt(line);
            }
        }
        if (current > max1) {
            max3 = max2;
            max2 = max1;
            max1 = current;

        } else if (current > max2) {
            max3 = max2;
            max2 = current;
        } else if (current > max3) {
            max3 = current;
        }

        return "" + (max1 + max2 + max3);
    }
}

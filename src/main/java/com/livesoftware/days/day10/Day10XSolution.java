package com.livesoftware.days.day10;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.List;

public class Day10XSolution implements Solution<List<Pair<Command, Integer>>> {

    @Override
    public String solve(List<Pair<Command, Integer>> input) {
        int register = 1;
        int sum = 0;
        int cycle = 0;
        for (var line : input) {
            switch (line.getFirst()) {
                case noop -> {
                    isVisible(register, cycle++);
                }
                case addx -> {
                    isVisible(register, cycle++);
                    isVisible(register, cycle++);
                    register += line.getSecond();
                }
            }
        }
        return "" + sum;
    }

    private void isVisible(int register, int cycle) {
        if (cycle % 40 == 0) {
            System.out.println();
        }
        if (register - 1 <= cycle % 40 && register + 1 >= cycle % 40) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }
    }
}

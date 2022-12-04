package com.livesoftware.days.day4;

import com.livesoftware.solver.Solution;
import java.util.Arrays;
import java.util.List;

public class Day4Solution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        return "" + input.stream()
                .map(this::getRangePair)
                .filter(this::overlap)
                .count();
    }

    private List<List<Integer>> getRangePair(String row) {
        return Arrays.stream(row.split(","))
                .map(this::getRange)
                .toList();
    }

    private List<Integer> getRange(String pair) {
        return Arrays.stream(pair.split("-"))
                .map(Integer::parseInt)
                .toList();
    }

    private boolean overlap(List<List<Integer>> pair) {
        int a1 = pair.get(0).get(0);
        int a2 = pair.get(0).get(1);
        int b1 = pair.get(1).get(0);
        int b2 = pair.get(1).get(1);

        return (a1 <= b1 && a2 >= b2)
                || (b1 <= a1 && b2 >= a2);
    }
}

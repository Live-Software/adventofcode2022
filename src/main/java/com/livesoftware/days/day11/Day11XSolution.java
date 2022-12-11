package com.livesoftware.days.day11;

import com.livesoftware.solver.Solution;
import java.util.Comparator;
import java.util.List;

public class Day11XSolution implements Solution<List<Monkey>> {
    @Override
    public String solve(List<Monkey> input) {
        int rounds = 10000;

        for (int i = 0; i < rounds; i++) {
            for (var monkey : input) {
                var mappy = monkey.turnMoreWorry();
                for (var elem : mappy.entrySet()) {
                    input.get(elem.getKey()).getItems().addAll(elem.getValue());
                }
            }
        }

        return "" + input.stream()
                .map(Monkey::getMonkeyBusiness)
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .reduce((s, x) -> s * x);

    }
}

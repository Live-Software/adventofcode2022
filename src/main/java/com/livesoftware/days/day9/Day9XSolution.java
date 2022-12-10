package com.livesoftware.days.day9;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day9XSolution implements Solution<List<Pair<Direction, Integer>>> {

    @Override
    public String solve(List<Pair<Direction, Integer>> input) {
        var knots = IntStream.range(0, 10)
                .boxed()
                .map(i -> Pair.of(0, 0))
                .collect(Collectors.toCollection(ArrayList::new));
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(Pair.of(0, 0));

        for (var line : input) {
            for (int i = 0; i < line.getSecond(); i++) {
                var headCoords = switch (line.getFirst()) {
                    case D -> Pair.of(knots.get(0).getFirst(), knots.get(0).getSecond() - 1);
                    case L -> Pair.of(knots.get(0).getFirst() - 1, knots.get(0).getSecond());
                    case U -> Pair.of(knots.get(0).getFirst(), knots.get(0).getSecond() + 1);
                    case R -> Pair.of(knots.get(0).getFirst() + 1, knots.get(0).getSecond());
                };
                knots.set(0, headCoords);
                for (int j = 0; j < knots.size() - 1; j++) {
                    var newPosition = moveKnots(knots.get(j), knots.get(j + 1));
                    knots.set(j + 1, newPosition);
                }
                visited.add(knots.get(9));
            }
        }

        return "" + visited.size();
    }

    private Pair<Integer, Integer> moveKnots(Pair<Integer, Integer> headCoords, Pair<Integer, Integer> tailCoords) {
        var diff = Pair.of(tailCoords.getFirst() - headCoords.getFirst(), tailCoords.getSecond() - headCoords.getSecond());
        if (diff.getFirst() == 2) {
            if (diff.getSecond() == 2) {
                return Pair.of(headCoords.getFirst() + 1, headCoords.getSecond() + 1);
            }
            if (diff.getSecond() == -2) {
                return Pair.of(headCoords.getFirst() + 1, headCoords.getSecond() - 1);
            }
            return Pair.of(headCoords.getFirst() + 1, headCoords.getSecond());
        }
        if (diff.getFirst() == -2) {
            if (diff.getSecond() == 2) {
                return Pair.of(headCoords.getFirst() - 1, headCoords.getSecond() + 1);
            }
            if (diff.getSecond() == -2) {
                return Pair.of(headCoords.getFirst() - 1, headCoords.getSecond() - 1);
            }
            return Pair.of(headCoords.getFirst() - 1, headCoords.getSecond());

        }
        if (diff.getSecond() == -2) {
            return Pair.of(headCoords.getFirst(), headCoords.getSecond() - 1);

        }
        if (diff.getSecond() == 2) {
            return Pair.of(headCoords.getFirst(), headCoords.getSecond() + 1);
        }
        return tailCoords;
    }
}

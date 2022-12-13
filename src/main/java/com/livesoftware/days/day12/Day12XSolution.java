package com.livesoftware.days.day12;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day12XSolution implements Solution<List<List<Integer>>> {
    @Override
    public String solve(List<List<Integer>> input) {

        var start = Pair.of(0, 0);
        for (int i = 0; i < input.size(); i++) {
            for (int j = 0; j < input.get(i).size(); j++) {
                if ('E' == input.get(i).get(j)) {
                    start = Pair.of(i, j);
                }
            }
        }
        var neighbours = getNeighbours(start, input);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        Set<Pair<Integer, Integer>> nextNeighbours = new HashSet<>();
        int steps = 1;
        visited.add(start);
        while (neighbours.stream().noneMatch(s -> getHeight(s, input) == 'a') && !neighbours.isEmpty()) {
            visited.addAll(neighbours);
            for (var nexty : neighbours) {
                var tempy = getNeighbours(nexty, input);
                for (var elem : tempy) {
                    if (!visited.contains(elem)) {
                        nextNeighbours.add(elem);
                    }
                }
            }
            steps++;
            neighbours.clear();
            neighbours.addAll(nextNeighbours);
            nextNeighbours.clear();
        }


        return "" + steps;
    }

    private List<Pair<Integer, Integer>> getNeighbours(Pair<Integer, Integer> coords, List<List<Integer>> input) {
        List<Pair<Integer, Integer>> result = new ArrayList<>();
        int current = getHeight(coords, input);

        if (coords.getFirst() > 0) {
            var nexty = Pair.of(coords.getFirst() - 1, coords.getSecond());
            if (getHeight(nexty, input) >= current - 1) {
                result.add(nexty);
            }
        }
        if (coords.getFirst() < input.size() - 1) {
            var nexty = Pair.of(coords.getFirst() + 1, coords.getSecond());
            if (getHeight(nexty, input) >= current - 1) {
                result.add(nexty);
            }
        }
        if (coords.getSecond() > 0) {
            var nexty = Pair.of(coords.getFirst(), coords.getSecond() - 1);
            if (getHeight(nexty, input) >= current - 1) {
                result.add(nexty);
            }
        }
        if (coords.getSecond() < input.get(coords.getFirst()).size() - 1) {
            var nexty = Pair.of(coords.getFirst(), coords.getSecond() + 1);
            if (getHeight(nexty, input) >= current - 1) {
                result.add(nexty);
            }
        }
        return result;
    }

    private int getHeight(Pair<Integer, Integer> coords, List<List<Integer>> input) {
        if ('E' == input.get(coords.getFirst()).get(coords.getSecond())) {
            return 'z';
        }
        if ('S' == input.get(coords.getFirst()).get(coords.getSecond())) {
            return 'a';
        } else return input.get(coords.getFirst()).get(coords.getSecond());

    }

}

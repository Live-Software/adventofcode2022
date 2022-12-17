package com.livesoftware.days.day15;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Day15XSolution implements Solution<Map<Pair<Integer, Integer>, Pair<Integer, Integer>>> {
    @Override
    public String solve(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> input) {
        Map<Pair<Integer, Integer>, Integer> distances = new HashMap<>();
        for (var sensor : input.keySet()) {
            distances.put(sensor, getDistance(sensor, input.get(sensor)));
        }

        var possibleCoords = distances.entrySet().stream()
                .flatMap(entry -> coordsOutsideSensorRange(distances, entry.getKey(), entry.getValue()))
                .collect(Collectors.toSet());

        for (var entry : distances.entrySet()) {
            System.out.println(entry.getKey().getFirst() + " " + entry.getKey().getSecond());
            for (int i = entry.getKey().getFirst() - entry.getValue() - 1; i <= entry.getKey().getFirst() + entry.getValue() + 1; i++) {
                var verticalOffset = entry.getValue() + 1 + i;
                if (isNotWithinRange(distances, entry.getKey().getSecond() + verticalOffset, entry.getKey().getFirst() + i)) {
                    return "" + (entry.getKey().getFirst() * 4000000 + entry.getKey().getSecond());
                }
            }
        }
        System.out.println(possibleCoords.size());
        return possibleCoords.stream()
                .filter(coord -> isNotWithinRange(distances, coord.getSecond(), coord.getFirst()))
                .findFirst()
                .map(coord -> "" + (coord.getFirst() * 4000000 + coord.getSecond()))
                .orElse("");
    }

    private Stream<Pair<Integer, Integer>> coordsOutsideSensorRange(Map<Pair<Integer, Integer>, Integer> distances, Pair<Integer, Integer> sensor, int distance) {
        return IntStream.rangeClosed(sensor.getFirst() - distance - 1, sensor.getFirst() + distance + 1)
                .boxed()
                .flatMap(i -> coordsAtDistance(distances, sensor, distance, i));
    }

    private Stream<Pair<Integer, Integer>> coordsAtDistance(Map<Pair<Integer, Integer>, Integer> distances, Pair<Integer, Integer> sensor, int distance, int offset) {
        var verticalOffset = distance + 1 + offset;
        return Stream.of(Pair.of(sensor.getFirst() + offset, sensor.getSecond() + verticalOffset), Pair.of(sensor.getFirst() + offset, sensor.getSecond() - verticalOffset))
                .filter(coords -> isNotWithinRange(distances, coords.getSecond(), coords.getFirst()));
    }

    private boolean isNotWithinRange(Map<Pair<Integer, Integer>, Integer> distances, int chosenRow, int i) {
        for (var sensor : distances.keySet()) {
            if (getDistance(sensor, Pair.of(i, chosenRow)) <= distances.get(sensor)) {
                return false;
            }
        }
        return true;
    }

    public int getDistance(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        return Math.abs(start.getSecond() - end.getSecond()) + Math.abs(start.getFirst() - end.getFirst());
    }
}

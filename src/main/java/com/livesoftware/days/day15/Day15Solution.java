package com.livesoftware.days.day15;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class Day15Solution implements Solution<Map<Pair<Integer, Integer>, Pair<Integer, Integer>>> {
    @Override
    public String solve(Map<Pair<Integer, Integer>, Pair<Integer, Integer>> input) {
        Map<Pair<Integer, Integer>, Integer> distances = new HashMap<>();
        int chosenRow = 2000000;
        for (var sensor : input.keySet()) {
            distances.put(sensor, getDistance(sensor, input.get(sensor)));
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (var sensor : distances.keySet()) {
            int vertDist = Math.abs(sensor.getSecond() - chosenRow);
            if (vertDist <= distances.get(sensor)) {
                int remainder = distances.get(sensor) - vertDist;
                if ((sensor.getFirst() - remainder) < min) {
                    min = sensor.getFirst() - remainder;
                }
                if ((sensor.getFirst() + remainder) > max) {
                    max = sensor.getFirst() + remainder;
                }
            }
        }
        int counter = 0;

        for (int i = min; i <= max; i++) {
            for (var sensor : distances.keySet()) {
                if (getDistance(sensor, Pair.of(i, chosenRow)) <= distances.get(sensor) && !input.containsValue(Pair.of(i, chosenRow))) {
                    counter++;
                    break;
                }
            }
        }


        return "" + counter;
    }

    public int getDistance(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        return Math.abs(start.getSecond() - end.getSecond()) + Math.abs(start.getFirst() - end.getFirst());
    }
}

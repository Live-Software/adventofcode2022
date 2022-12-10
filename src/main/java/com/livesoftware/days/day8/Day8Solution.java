package com.livesoftware.days.day8;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day8Solution implements Solution<List<List<Integer>>> {
    @Override
    public String solve(List<List<Integer>> input) {

        Set<Pair<Integer, Integer>> counted = new HashSet<>();
        for (int i = 0; i < input.size(); i++) {
            var line = input.get(i);
            int currentBigest = line.get(0);
            counted.add(Pair.of(i, 0));

            for (int j = 0; j < line.size(); j++) {
                int curr = line.get(j);
                if (currentBigest < curr) {
                    counted.add(Pair.of(i, j));
                    currentBigest = curr;
                }
            }
            currentBigest = line.get(line.size() - 1);
            counted.add(Pair.of(i, line.size() - 1));
            for (int j = line.size() - 1; j >= 0; j--) {
                int curr = line.get(j);
                if (currentBigest < curr) {
                    counted.add(Pair.of(i, j));
                    currentBigest = curr;
                }
            }
        }

        for (int j = 0; j < input.get(0).size(); j++) {
            int currentBiggest = input.get(0).get(j);
            counted.add(Pair.of(0, j));
            for (int i = 0; i < input.size(); i++) {
                if (currentBiggest < input.get(i).get(j)) {
                    counted.add(Pair.of(i, j));
                    currentBiggest = input.get(i).get(j);
                }
            }
            currentBiggest = input.get(input.size() - 1).get(j);
            counted.add(Pair.of(input.size() - 1, j));
            for (int i = input.size() - 1; i >= 0; i--) {
                if (currentBiggest < input.get(i).get(j)) {
                    counted.add(Pair.of(i, j));
                    currentBiggest = input.get(i).get(j);
                }
            }

        }
        return "" + counted.size();
    }
}

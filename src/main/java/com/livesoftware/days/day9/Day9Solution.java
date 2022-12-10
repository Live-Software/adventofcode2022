package com.livesoftware.days.day9;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day9Solution implements Solution<List<Pair<Direction, Integer>>> {

    @Override
    public String solve(List<Pair<Direction, Integer>> input) {
        Pair<Integer, Integer> headCoords = Pair.of(0, 0);
        Pair<Integer, Integer> tailCoords = Pair.of(0, 0);
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(Pair.of(0, 0));

        for (var line : input) {
            for (int i = 0; i < line.getSecond(); i++) {
                headCoords = switch (line.getFirst()) {
                    case D -> Pair.of(headCoords.getFirst(), headCoords.getSecond() - 1);
                    case L -> Pair.of(headCoords.getFirst() - 1, headCoords.getSecond());
                    case U -> Pair.of(headCoords.getFirst(), headCoords.getSecond() + 1);
                    case R -> Pair.of(headCoords.getFirst() + 1, headCoords.getSecond());
                };
                if (tailCoords.getFirst() - headCoords.getFirst() == 2) {
                    tailCoords = Pair.of(headCoords.getFirst() + 1, headCoords.getSecond());
                
                }
                if (tailCoords.getFirst() - headCoords.getFirst() == -2) {
                    tailCoords = Pair.of(headCoords.getFirst() - 1, headCoords.getSecond());

                }
                if (tailCoords.getSecond() - headCoords.getSecond() == -2) {
                    tailCoords = Pair.of(headCoords.getFirst(), headCoords.getSecond() - 1);

                }
                if (tailCoords.getSecond() - headCoords.getSecond() == 2) {
                    tailCoords = Pair.of(headCoords.getFirst(), headCoords.getSecond() + 1);
                }
                visited.add(tailCoords);


            }
        }

        return "" + visited.size();
    }
}

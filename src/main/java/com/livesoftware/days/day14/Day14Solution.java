package com.livesoftware.days.day14;

import com.livesoftware.solver.Solution;
import com.livesoftware.util.Pair;
import java.util.HashSet;

public class Day14Solution implements Solution<Cave> {
    @Override
    public String solve(Cave input) {
        var rocks = new HashSet<>(input.getRocks());
        int counter = 0;
        var current = Pair.of(500, 0);
        var bottom = input.bottom();
        while (!current.getSecond().equals(bottom)) {
            current = Pair.of(500, 0);
            while (!whereToFall(current, input, bottom).equals(Pair.of(0, 0))) {
                current = whereToFall(current, input, bottom);
            }
            input.addRock(current);
//            System.out.println(counter);
            counter++;
        }

        for (int i = 0; i < input.bottom() + 1; i++) {
            for (int j = 0; j < input.right() + 2; j++) {
                if (j == 500 && i == 0) {
                    System.out.print("+");
                    continue;
                }
                if (rocks.contains(Pair.of(j, i))) {
                    System.out.print("#");
                    continue;
                }
                if (input.isRock(j, i)) {
                    System.out.print("O");
                    continue;
                }
                System.out.print(".");
            }
            System.out.println();
        }

        return "" + (counter - 1);
    }

    private Pair<Integer, Integer> whereToFall(Pair<Integer, Integer> coords, Cave cave, int bottom) {
        if (coords.getSecond() + 1 > bottom) {
            return Pair.of(0, 0);
        }
        if (!cave.isRock(coords.getFirst(), coords.getSecond() + 1)) {
            return Pair.of(coords.getFirst(), coords.getSecond() + 1);
        }
        if (!cave.isRock(coords.getFirst() + 1, coords.getSecond() + 1)) {
            return Pair.of(coords.getFirst() + 1, coords.getSecond() + 1);
        }
        if (!cave.isRock(coords.getFirst() - 1, coords.getSecond() + 1)) {
            return Pair.of(coords.getFirst() - 1, coords.getSecond() + 1);
        }
        return Pair.of(0, 0);
    }


}

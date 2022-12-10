package com.livesoftware.days.day8;

import com.livesoftware.solver.Solution;
import java.util.List;

public class Day8XSolution implements Solution<List<List<Integer>>> {
    @Override
    public String solve(List<List<Integer>> input) {
        int max = 0;
        for (int i = 1; i < input.size() - 1; i++) {
            for (int j = 1; j < input.get(i).size() - 1; j++) {
                int current = input.get(i).get(j);
                int x = j - 1;
                while (x > 0 && input.get(i).get(x) < current) {
                    x--;
                }
                int countMinusHorizintal = j - x;
                x = j + 1;
                while (x < input.get(i).size() - 1 && input.get(i).get(x) < current) {
                    x++;
                }
                int countPlusHorisontal = x - j;

                int y = i - 1;
                while (y > 0 && input.get(y).get(j) < current) {
                    y--;
                }
                int countMinusVertical = i - y;
                y = i + 1;
                while (y < input.size() - 1 && input.get(y).get(j) < current) {
                    y++;
                }
                int countPlusVertical = y - i;
                int cur = countMinusVertical * countPlusVertical * countMinusHorizintal * countPlusHorisontal;
                if (max < cur) {
                    max = cur;
                }
            }
        }
        return "" + max;
    }
}

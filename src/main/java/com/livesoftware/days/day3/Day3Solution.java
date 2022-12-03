package com.livesoftware.days.day3;

import com.livesoftware.solver.Solution;
import java.util.ArrayList;
import java.util.List;

public class Day3Solution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        int sum = 0;
        for (String line : input) {
            List<Character> sack = new ArrayList<>();
            for (int i = 0; i < line.length(); i++) {
                if (i < line.length() / 2) {
                    sack.add(line.charAt(i));
                } else {
                    if (sack.contains(line.charAt(i))) {
                        sum += line.charAt(i) - (line.charAt(i) < 'a' ? 'A' - 26 : 'a') + 1;
                        break;
                    }
                }
            }
        }
        return "" + sum;
    }
}

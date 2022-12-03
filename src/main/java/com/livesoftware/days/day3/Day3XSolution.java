package com.livesoftware.days.day3;

import com.livesoftware.solver.Solution;
import java.util.List;

public class Day3XSolution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        int sum = 0;
        int i = 0;
        String common = "";
        while (i < input.size()) {
            String suck1 = input.get(i++);
            String suck2 = input.get(i++);
            String suck3 = input.get(i++);
            for (int j = 0; j < suck1.length(); j++) {
                if (suck2.contains(suck1.substring(j, j + 1)) && suck3.contains(suck1.substring(j, j + 1))) {
                    common = suck1.substring(j, j + 1);
                    break;
                }
            }
            sum += common.charAt(0) - (common.charAt(0) < 'a' ? 'A' - 26 : 'a') + 1;

        }
        return "" + sum;
    }
}

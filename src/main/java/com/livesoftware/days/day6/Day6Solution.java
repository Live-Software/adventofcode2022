package com.livesoftware.days.day6;

import com.livesoftware.solver.Solution;
import java.util.List;

public class Day6Solution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        String inputWord = input.get(0);
        for (int i = 3; i < inputWord.length(); i++) {
            String sub1 = inputWord.substring(i - 3, i - 2);
            String sub2 = inputWord.substring(i - 2, i - 1);
            String sub3 = inputWord.substring(i - 1, i);
            String sub4 = inputWord.substring(i, i + 1);

            if (!sub1.equals(sub2)
                    && !sub1.equals(sub3)
                    && !sub1.equals(sub4)
                    && !sub2.equals(sub4)
                    && !sub2.equals(sub3)
                    && !sub4.equals(sub3)) {
                return "" + (i + 1);
            }
        }
        return "NO";
    }
}

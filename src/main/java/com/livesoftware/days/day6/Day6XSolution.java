package com.livesoftware.days.day6;

import com.livesoftware.solver.Solution;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6XSolution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        String inputWord = input.get(0);
        for (int i = 13; i < inputWord.length(); i++) {
            String substring = inputWord.substring(i - 13, i + 1);
            Set<Character> chars = new HashSet<>();
            boolean diffy = true;
            for (Character c : substring.toCharArray()
            ) {
                if (chars.contains(c)) {
                    diffy = false;
                    break;
                }
                chars.add(c);
            }
            if (diffy) {
                return "" + (i + 1);
            }
        }
        return "NO";
    }
}

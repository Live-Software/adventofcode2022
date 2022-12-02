package com.livesoftware.days.day2;

import com.livesoftware.solver.Solution;
import java.util.List;
import java.util.Objects;

public class Day2Solution implements Solution<List<String>> {
    @Override
    public String solve(List<String> input) {
        int score = 0;
        for (String line : input
        ) {
            var plays = line.split(" ");
            RPS enemy = RPS.PAPER;
            if (Objects.equals(plays[0], "A")) {
                enemy = RPS.ROCK;
            } else if (plays[0].equals("C")) {
                enemy = RPS.SCISSORS;
            }
            RPS us = RPS.PAPER;
            if (plays[1].equals("X")) {
                us = RPS.ROCK;
            } else if (plays[1].equals("Z")) {
                us = RPS.SCISSORS;
            }
            score += us.getValue();
            if (us.equals(enemy)) {
                score += 3;
            } else if (us.beats(enemy)) {
                score += 6;
            }
        }
        return "" + score;
    }
}

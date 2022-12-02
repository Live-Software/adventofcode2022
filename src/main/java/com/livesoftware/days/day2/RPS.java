package com.livesoftware.days.day2;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RPS {
    ROCK(1),
    PAPER(2),
    SCISSORS(3);

    private final int value;

    public boolean beats(RPS other) {
        return (this == ROCK && other == SCISSORS)
                || (this == PAPER && other == ROCK)
                || (this == SCISSORS && other == PAPER);
    }
}

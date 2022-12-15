package com.livesoftware.days.day14;

import com.livesoftware.util.Pair;
import lombok.Builder;
import lombok.Getter;
import java.util.Comparator;
import java.util.Set;

@Builder
public class Cave {
    @Getter
    private final Set<Pair<Integer, Integer>> rocks;

    public boolean isRock(Pair<Integer, Integer> coords) {
        return rocks.contains(coords);
    }

    public boolean isRock(int x, int y) {
        return isRock(Pair.of(x, y));
    }

    public void addRock(Pair<Integer, Integer> rock) {
        rocks.add(rock);
    }

    public void addRock(int x, int y) {
        addRock(Pair.of(x, y));
    }

    public int bottom() {
        return rocks.stream()
                .max(Comparator.comparing(Pair::getSecond))
                .map(Pair::getSecond)
                .orElse(-1);
    }

    public int right() {
        return rocks.stream()
                .max(Comparator.comparing(Pair::getFirst))
                .map(Pair::getFirst)
                .orElse(-1);
    }
}

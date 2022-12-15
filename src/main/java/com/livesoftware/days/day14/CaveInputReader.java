package com.livesoftware.days.day14;

import com.livesoftware.input.InputMapper;
import com.livesoftware.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CaveInputReader implements InputMapper<Cave> {
    @Override
    public Cave mapInput(List<String> input) {
        return Cave.builder()
                .rocks(mapInputToRocks(input))
                .build();
    }

    private Set<Pair<Integer, Integer>> mapInputToRocks(List<String> input) {
        return input.stream()
                .map(this::rowToCoordList)
                .flatMap(List::stream)
                .collect(Collectors.toCollection(HashSet::new));
    }

    private List<Pair<Integer, Integer>> rowToCoordList(String row) {
        return Arrays.stream(row.split(" -> "))
                .map(coordPair -> coordPair.split(","))
                .map(coords -> Pair.of(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])))
                .reduce(new ArrayList<>(), this::accumulate, this::combine);
    }

    private List<Pair<Integer, Integer>> accumulate(List<Pair<Integer, Integer>> current, Pair<Integer, Integer> target) {
        if (current.size() < 1) {
            current.add(target);
            return current;
        }
        current.addAll(coordsToLine(current.get(current.size() - 1), target));
        return current;
    }

    private List<Pair<Integer, Integer>> combine(List<Pair<Integer, Integer>> first, List<Pair<Integer, Integer>> second) {
        first.addAll(second);
        return first;
    }

    private List<Pair<Integer, Integer>> coordsToLine(Pair<Integer, Integer> start, Pair<Integer, Integer> end) {
        return numbersBetween(start.getFirst(), end.getFirst()).stream()
                .flatMap(x -> numbersBetween(start.getSecond(), end.getSecond()).stream()
                        .map(y -> Pair.of(x, y)))
                .toList();
    }

    private List<Integer> numbersBetween(Integer start, Integer end) {
        return IntStream.rangeClosed(Math.min(start, end), Math.max(start, end))
                .boxed()
                .toList();
    }
}

package com.livesoftware.days.day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
public class Monkey {
    private List<Long> items;
    private Function<Long, Long> operation;
    private long divisibleBy;
    private int trueIndex;
    private int falseIndex;
    private long monkeyBusiness;


    public Map<Integer, List<Long>> turn() {
        monkeyBusiness += items.size();
        var thrownItems = items.stream()
                .map(operation)
                .map(i -> i / 3)
                .collect(Collectors.groupingBy(i -> i % divisibleBy == 0 ? trueIndex : falseIndex));
        items.clear();
        return thrownItems;
    }

    public Map<Integer, List<Long>> turnMoreWorry() {
        monkeyBusiness += items.size();
        var thrownItems = items.stream()
                .map(operation)
                .map(i -> i % (13 * 11 * 2 * 5 * 7 * 3 * 19 * 17))
                .collect(Collectors.groupingBy(i -> i % divisibleBy == 0 ? trueIndex : falseIndex));
        items.clear();
        return thrownItems;
    }
}

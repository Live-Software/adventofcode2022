package com.livesoftware.days.day11;

import com.livesoftware.input.InputMapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MonkeyInputMapper implements InputMapper<List<Monkey>> {

    @Override
    public List<Monkey> mapInput(List<String> input) {
        List<Monkey> result = new ArrayList<>();
        for (int i = 0; i < input.size(); i += 7) {
            var numbers = Arrays.stream(input.get(i + 1).split(": ")[1].split(", "))
                    .map(Long::parseLong)
                    .collect(Collectors.toCollection(ArrayList::new));
            var operation = extractOperation(input.get(i + 2));
            var divisibleBy = Integer.parseInt(input.get(i + 3).split(" ")[5]);
            var trueVal = Integer.parseInt(input.get(i + 4).split(" ")[9]);
            var falseVal = Integer.parseInt(input.get(i + 5).split(" ")[9]);
            result.add(new Monkey(numbers, operation, divisibleBy, trueVal, falseVal, 0));
        }

        return result;
    }

    private Function<Long, Long> extractOperation(String line) {
        var operation = line.split("= ")[1];
        var elements = operation.split(" ");
        if ("old".equals(elements[2])) {
            if ("+".equals(elements[1])) {
                return old -> old + old;
            }
            return old -> old * old;
        }
        if ("+".equals(elements[1])) {
            return old -> old + Integer.parseInt(elements[2]);
        }
        return old -> old * Integer.parseInt(elements[2]);
    }
}

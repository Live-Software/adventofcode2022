package com.livesoftware.days.day10;

import com.livesoftware.input.InputMapper;
import com.livesoftware.util.Pair;
import java.util.List;

public class CommandInputMapper implements InputMapper<List<Pair<Command, Integer>>> {

    @Override
    public List<Pair<Command, Integer>> mapInput(List<String> input) {
        return input.stream()
                .map(line -> line.split(" "))
                .map(line -> Pair.of(Command.valueOf(line[0]), line.length > 1 ? Integer.parseInt(line[1]) : null))
                .toList();
    }
}

package com.livesoftware.days.day9;

import com.livesoftware.input.InputMapper;
import com.livesoftware.util.Pair;
import java.util.List;

public class RopeMovementInputMapper implements InputMapper<List<Pair<Direction, Integer>>> {
    @Override
    public List<Pair<Direction, Integer>> mapInput(List<String> input) {
        return input.stream()
                .map(inp -> inp.split(" "))
                .map(row -> Pair.of(Direction.valueOf(row[0]), Integer.parseInt(row[1])))
                .toList();
    }
}

package com.livesoftware.days.day8;

import com.livesoftware.input.InputMapper;
import java.util.List;

public class IntListListInputMapper implements InputMapper<List<List<Integer>>> {
    @Override
    public List<List<Integer>> mapInput(List<String> input) {
        return input.stream()
                .map(line -> line.chars().boxed().map(c -> c - '0').toList())
                .toList();
    }
}

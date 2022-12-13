package com.livesoftware.days.day12;

import com.livesoftware.input.InputMapper;
import java.util.List;

public class CharToIntListListInputMapper implements InputMapper<List<List<Integer>>> {
    @Override
    public List<List<Integer>> mapInput(List<String> input) {
        return input.stream()
                .map(line -> line.chars().boxed().toList()).toList();
    }
}

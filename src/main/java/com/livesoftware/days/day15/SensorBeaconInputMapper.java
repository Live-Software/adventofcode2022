package com.livesoftware.days.day15;

import com.livesoftware.input.InputMapper;
import com.livesoftware.util.Pair;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SensorBeaconInputMapper implements InputMapper<Map<Pair<Integer, Integer>, Pair<Integer, Integer>>> {
    @Override
    public Map<Pair<Integer, Integer>, Pair<Integer, Integer>> mapInput(List<String> input) {
        return input.stream()
                .map(line -> line.split(" "))
                .collect(Collectors.toMap(line ->
                                Pair.of(Integer.parseInt(line[2].substring(2, line[2].length() - 1)),
                                        Integer.parseInt(line[3].substring(2, line[3].length() - 1))),
                        line ->
                                Pair.of(Integer.parseInt(line[8].substring(2, line[8].length() - 1)),
                                        Integer.parseInt(line[9].substring(2)))
                ));
    }
}

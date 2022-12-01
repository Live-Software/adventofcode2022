package com.livesoftware.solver;

import com.livesoftware.input.InputMapper;
import com.livesoftware.input.InputReader;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DaySolver<InputT> {
    private final InputReader inputReader;
    private final InputMapper<InputT> inputMapper;
    private final Solution<InputT> solution;

    public String solveDay(String source) {
        var inputStream = inputReader.readInput(source);
        var input = inputMapper.mapInput(inputStream);
        return solution.solve(input);
    }
}

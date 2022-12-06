package com.livesoftware.days.day5;

import com.livesoftware.input.InputMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackerInputMapper implements InputMapper<Stacker> {
    @Override
    public Stacker mapInput(List<String> input) {
        var stacksLines = input.stream()
                .takeWhile(line -> !line.isEmpty())
                .toList();
        var stackRows = stacksLines.stream()
                .map(this::toStackRow)
                .toList();
        var stacks = new ArrayList<Stack<String>>();
        for (int i = stackRows.size() - 1; i >= 0; i--) {
            for (int j = 0; j < stackRows.get(i).size(); j++) {
                if (i == 8) {
                    var stack = new Stack<String>();
                    if (!stackRows.get(i).get(j).equals(" ")) {
                        stack.add(stackRows.get(i).get(j));
                    }
                    stacks.add(stack);
                } else {
                    var stack = stacks.get(j);
                    if (!stackRows.get(i).get(j).equals(" ")) {
                        stack.add(stackRows.get(i).get(j));
                    }
                }
            }
        }
        var moves = input.stream()
                .skip(stacksLines.size() + 1)
                .map(line -> line.split(" "))
                .map(line -> new Move(Integer.parseInt(line[1]), Integer.parseInt(line[3]), Integer.parseInt(line[5])))
                .toList();
        return new Stacker(stacks, moves);

    }

    private List<String> toStackRow(String row) {
        var result = new ArrayList<String>();
        for (int i = 0; i < row.length(); i += 4) {
            result.add(row.substring(i + 1, i + 2));
        }
        return result;
    }
}

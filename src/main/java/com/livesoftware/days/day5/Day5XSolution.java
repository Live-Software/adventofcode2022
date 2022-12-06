package com.livesoftware.days.day5;

import com.livesoftware.solver.Solution;
import java.util.Stack;

public class Day5XSolution implements Solution<Stacker> {
    @Override
    public String solve(Stacker input) {
        var moves = input.getMoves();
        var stacks = input.getStacks();

        for (var move : moves) {
            var newStack = new Stack<String>();
            for (int i = 0; i < move.amount(); i++) {
                newStack.add(stacks.get(move.from() - 1).pop());
            }
            while (!newStack.empty()) {
                stacks.get(move.to() - 1).add(newStack.pop());
            }
        }
        var res = new StringBuilder();
        for (var stack : stacks) {
            res.append(stack.peek());
        }
        return res.toString();
    }
}

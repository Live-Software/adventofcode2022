package com.livesoftware.days.day5;

import com.livesoftware.solver.Solution;

public class Day5Solution implements Solution<Stacker> {
    @Override
    public String solve(Stacker input) {
        var moves = input.getMoves();
        var stacks = input.getStacks();

        for (var move : moves) {
            for (int i = 0; i < move.amount(); i++) {
                stacks.get(move.to() - 1).add(stacks.get(move.from() - 1).pop());
            }
        }
        var res = new StringBuilder();
        for (var stack : stacks) {
            res.append(stack.peek());
        }
        return res.toString();
    }
}

package com.livesoftware.days.day5;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;
import java.util.Stack;

@Data
@AllArgsConstructor
public class Stacker {
    private List<Stack<String>> stacks;
    private List<Move> moves;
}

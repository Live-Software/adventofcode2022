package com.livesoftware.input;

import java.util.List;

@FunctionalInterface
public interface InputReader {
    List<String> readInput(String source);
}

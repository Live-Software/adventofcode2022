package com.livesoftware.solver;

@FunctionalInterface
public interface Solution<InputT>{
    String solve(InputT input);
}

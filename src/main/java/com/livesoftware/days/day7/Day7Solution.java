package com.livesoftware.days.day7;

import com.livesoftware.solver.Solution;
import java.util.ArrayList;

public class Day7Solution implements Solution<Directory> {
    @Override
    public String solve(Directory input) {
        var sum = 0;
        var directoriesToLookAt = new ArrayList<Directory>();
        directoriesToLookAt.add(input);
        while (!directoriesToLookAt.isEmpty()) {
            var currentDirectory = directoriesToLookAt.remove(0);
            directoriesToLookAt.addAll(currentDirectory.getDirectories().values());
            if (currentDirectory.getSize() <= 100000) {
                sum += currentDirectory.getSize();
            }
        }
        return "" + sum;
    }
}

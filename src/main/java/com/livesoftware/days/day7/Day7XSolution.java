package com.livesoftware.days.day7;

import com.livesoftware.solver.Solution;
import java.util.ArrayList;

public class Day7XSolution implements Solution<Directory> {
    @Override
    public String solve(Directory input) {
        var rootSize = input.getSize();
        var spaceNeeded = 30000000 - (70000000 - rootSize);
        var smallestSpace = rootSize;
        var directoriesToLookAt = new ArrayList<Directory>();
        directoriesToLookAt.add(input);
        while (!directoriesToLookAt.isEmpty()) {
            var currentDirectory = directoriesToLookAt.remove(0);
            directoriesToLookAt.addAll(currentDirectory.getDirectories().values());
            var currentSize = currentDirectory.getSize();
            if (currentSize >= spaceNeeded && currentSize < smallestSpace) {
                smallestSpace = currentSize;
            }
        }
        return "" + smallestSpace;
    }
}

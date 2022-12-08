package com.livesoftware.days.day7;

import com.livesoftware.input.InputMapper;
import java.util.List;

public class DirectoryInputMapper implements InputMapper<Directory> {
    @Override
    public Directory mapInput(List<String> input) {
        var rootDirecory = new Directory("/");
        var currentDirectory = rootDirecory;
        for (var lineOfInput : input) {
            var line = lineOfInput.split(" ");
            if ("$".equals(line[0])) {
                if ("cd".equals(line[1])) {
                    if ("/".equals(line[2])) {
                        currentDirectory = rootDirecory;
                        continue;
                    }
                    if ("..".equals(line[2])) {
                        currentDirectory = currentDirectory.getParent();
                        continue;
                    }
                    currentDirectory = currentDirectory.getDirectories().get(line[2]);
                    continue;
                }
                continue;
            }
            if ("dir".equals(line[0])) {
                currentDirectory.getDirectories().put(line[1], new Directory(line[1], currentDirectory));
                continue;
            }
            currentDirectory.getFiles().put(line[1], new File(line[1], Integer.parseInt(line[0])));
        }
        return rootDirecory;
    }
}

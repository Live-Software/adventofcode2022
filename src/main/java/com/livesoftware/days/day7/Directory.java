package com.livesoftware.days.day7;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

@Data
public class Directory {
    private String name;
    private Directory parent;
    private Map<String, Directory> directories;
    private Map<String, File> files;

    public Directory(String name) {
        this(name, null);
    }

    public Directory(String name, Directory parent) {
        this.name = name;
        this.parent = parent;
        this.directories = new HashMap<>();
        this.files = new HashMap<>();
    }

    public long getSize() {
        return files.values().stream()
                .mapToInt(File::getSize)
                .sum()
                + directories.values().stream()
                .mapToLong(Directory::getSize)
                .sum();
    }
}

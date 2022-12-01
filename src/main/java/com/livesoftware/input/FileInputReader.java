package com.livesoftware.input;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileInputReader implements InputReader{
    @Override
    public List<String> readInput(String source) {
        try {
            return Files.readAllLines(Path.of(source));
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}

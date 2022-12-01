package com.livesoftware.input;

import java.util.List;

@FunctionalInterface
public interface InputMapper<InputT> {
    InputT mapInput(List<String> input);
}

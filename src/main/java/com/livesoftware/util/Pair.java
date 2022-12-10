package com.livesoftware.util;

import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
public class Pair<T, R> {
    private final T first;
    private final R second;

    private Pair(T first, R second) {
        this.first = first;
        this.second = second;
    }

    public static <T, R> Pair<T, R> of(T first, R second) {
        return new Pair<>(first, second);
    }

}

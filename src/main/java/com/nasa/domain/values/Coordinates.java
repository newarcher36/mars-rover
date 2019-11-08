package com.nasa.domain.values;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class Coordinates {
    protected final int x;
    protected final int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

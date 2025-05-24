package com.jannotate.common.enums;

import java.awt.Color;

public enum TextColor {
    BLACK(Color.BLACK),
    WHITE(Color.WHITE),
    RED(Color.RED),
    GREEN(Color.GREEN),
    BLUE(Color.BLUE),
    YELLOW(Color.YELLOW),
    CYAN(Color.CYAN),
    MAGENTA(Color.MAGENTA),
    GRAY(Color.GRAY),
    ORANGE(Color.ORANGE),
    NULL(null);

    private final Color color;

    TextColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}

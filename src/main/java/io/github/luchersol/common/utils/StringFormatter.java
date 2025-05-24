package com.jannotate.common.utils;

public class StringFormatter {

    private StringBuilder stringBuilder;

    private StringFormatter() {
        this.stringBuilder = new StringBuilder();
    }

    public static StringFormatter init() {
        return new StringFormatter();
    }

    public static final String RESET = "\u001B[0m";
    public static final String RESET_STYLES = "\u001B[22m\u001B[23m\u001B[24m\u001B[27m";

    public enum Font {
        BOLD("\u001B[1m"),
        ITALIC("\u001B[3m"),
        UNDERLINE("\u001B[4m"),
        INVERT("\u001B[7m"),
        NORMAL_BOLD("\u001B[22m"),
        NORMAL_ITALIC("\u001B[23m"),
        NORMAL_UNDERLINE("\u001B[24m"),
        NORMAL_INVERT("\u001B[27m");

        private final String code;

        Font(String code) {
            this.code = code;
        }

        public String getCode() {
            return this.code;
        }
    }

    public enum Color {
        BLACK("\u001B[30m"),
        RED("\u001B[31m"),
        GREEN("\u001B[32m"),
        YELLOW("\u001B[33m"),
        BLUE("\u001B[34m"),
        MAGENTA("\u001B[35m"),
        CYAN("\u001B[36m"),
        WHITE("\u001B[37m");

        private final String code;

        Color(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public StringFormatter append(String value) {
        this.stringBuilder.append(value);
        return this;
    }

    public StringFormatter ifAppend(boolean condition, String value) {
        return condition ? append(value) : this;
    }

    public StringFormatter reset() {
        this.append(RESET);
        return this;
    }

    public StringFormatter resetStyles() {
        this.append(RESET_STYLES);
        return this;
    }

    public StringFormatter color(Color color) {
        return this.append(color.code);
    }

    public StringFormatter font(Font font) {
        return this.append(font.code);
    }

    @Override
    public String toString() {
        return this.stringBuilder.toString();
    }

}

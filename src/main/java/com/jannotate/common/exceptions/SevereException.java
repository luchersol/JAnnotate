package com.jannotate.common.exceptions;

public class SevereException extends Exception {
    public SevereException(String message) {
        super(message);
    }

    public SevereException(Throwable throwable) {
        this(getErrorMessage(throwable));
    }

    private static String getErrorMessage(Throwable e) {
        while (e.getCause() != null) {
            e = e.getCause();
        }
        return e.getMessage() != null ? e.getMessage() : "Unknown error";
    }
}

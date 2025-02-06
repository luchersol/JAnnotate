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

    public static SevereException of(String message) {
        return new SevereException(message);
    }

    public static SevereException of(Throwable throwable) {
        return new SevereException(throwable);
    }

    public static void throw_exception(String message) throws SevereException {
        throw new SevereException(message);
    }

    public static void throw_exception(Throwable throwable) throws SevereException {
        throw new SevereException(throwable);
    }
}

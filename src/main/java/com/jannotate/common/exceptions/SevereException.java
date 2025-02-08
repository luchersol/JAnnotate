package com.jannotate.common.exceptions;

import java.util.Collection;

public class SevereException extends LogException {

    public SevereException(String message) {
        super(message);
    }

    public SevereException(Collection<String> messages) {
        super(messages);
    }

    public SevereException(Throwable throwable) {
        super(throwable);
    }

    public static SevereException of(String message) {
        return new SevereException(message);
    }

    public static SevereException of(Collection<String> messages) {
        return new SevereException(messages);
    }

    public static SevereException of(Throwable throwable) {
        return new SevereException(throwable);
    }

    public static void throw_exception(String message) throws LogException {
        throw new SevereException(message);
    }

    public static void throw_exception(Collection<String> messages) throws LogException {
        throw new SevereException(messages);
    }

    public static void throw_exception(Throwable throwable) throws LogException {
        throw new SevereException(throwable);
    }
}

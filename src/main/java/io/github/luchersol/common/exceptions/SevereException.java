package io.github.luchersol.common.exceptions;

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

    public static void throwException(String message) throws LogException {
        throw new SevereException(message);
    }

    public static void throwException(Collection<String> messages) throws LogException {
        throw new SevereException(messages);
    }

    public static void throwException(Throwable throwable) throws LogException {
        throw new SevereException(throwable);
    }
}

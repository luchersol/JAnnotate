package com.jannotate.common.exceptions;

import java.util.Collection;
import java.util.List;

public class WarningException extends LogException {

    public WarningException(String message) {
        super(message);
    }

    public WarningException(Collection<String> messages) {
        super(messages);
    }

    public WarningException(Throwable throwable) {
        super(throwable);
    }

    public static WarningException of(String message) {
        return new WarningException(message);
    }

    public static WarningException of(Collection<String> messages) {
        return new WarningException(messages);
    }

    public static WarningException of(Throwable throwable) {
        return new WarningException(throwable);
    }

    public static void throw_exception(String message) throws LogException {
        throw new WarningException(message);
    }

    public static void throw_exception(List<String> messages) throws LogException {
        throw new WarningException(messages);
    }

    public static void throw_exception(Throwable throwable) throws LogException {
        throw new WarningException(throwable);
    }
}

package io.github.luchersol.common.exceptions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class LogException extends Exception {

    protected List<String> messages;

    public LogException(String message) {
        this.messages = new ArrayList<>(List.of(message));
    }

    public LogException(Collection<String> messages) {
        this.messages = new ArrayList<>(messages);
    }

    public LogException(Throwable throwable) {
        this(getErrorMessage(throwable));
    }

    @Override
    public String getMessage() {
        if (this.messages.size() == 1) {
            return this.messages.get(0);
        } else {
            StringBuilder stringBuilder = new StringBuilder("\n");
            for (String message : messages) {
                stringBuilder.append(" - ");
                stringBuilder.append(message);
                stringBuilder.append(".\n");
            }
            return stringBuilder.toString();
        }
    }

    protected static String getErrorMessage(Throwable e) {
        while (e.getCause() != null) {
            e = e.getCause();
        }
        return e.getMessage() != null ? e.getMessage() : "Unknown error";
    }
}

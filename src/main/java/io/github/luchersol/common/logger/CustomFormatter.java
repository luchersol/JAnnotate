package io.github.luchersol.common.logger;

import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

import io.github.luchersol.common.utils.StringFormatter;
import io.github.luchersol.common.utils.StringFormatter.Color;
import io.github.luchersol.common.utils.StringFormatter.Font;

public class CustomFormatter extends SimpleFormatter {

    static boolean show_instance = true;
    static boolean show_logger_name = true;

    // Levels: OFF, SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST, ALL
    @Override
    public String format(LogRecord record) {

        Color color = switch (record.getLevel().toString()) {
            case "INFO" -> Color.BLUE;
            case "WARNING" -> Color.YELLOW;
            case "SEVERE" -> Color.RED;
            default -> Color.BLACK;
        };

        StringFormatter format = StringFormatter.init()
                .color(color).font(Font.BOLD)
                .ifAppend(show_instance, "[%1$tF %1$tT] ")
                .append("[%2$s] ")
                .ifAppend(show_logger_name, "<%3$s> ")
                .resetStyles()
                .append("%4$s %n")
                .reset();

        return String.format(format.toString(),
                record.getMillis(),
                record.getLevel(),
                record.getLoggerName(),
                record.getMessage());
    }

}

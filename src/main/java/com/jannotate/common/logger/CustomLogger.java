package com.jannotate.common.logger;

import java.io.FileInputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CustomLogger extends Logger {

    public static void load() {
        try (FileInputStream input = new FileInputStream("src/main/resources/log.config")) {
            LogManager logManager = LogManager.getLogManager();
            logManager.readConfiguration(input);
            CustomFormatter.show_logger_name = Boolean.valueOf(logManager.getProperty("formatter.show_logger_name"));
            CustomFormatter.show_instance = Boolean.valueOf(logManager.getProperty("formatter.show_instance"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomLogger(String name, String resourceBundleName) {
        super(name, null);
    }

}

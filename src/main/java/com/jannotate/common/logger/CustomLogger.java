package com.jannotate.common.logger;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class CustomLogger extends Logger {

    public static void load() {
        try (InputStream input = CustomLogger.class.getClassLoader().getResourceAsStream("log.config")) {
            if (input == null) {
                throw new FileNotFoundException("log.config file not found");
            }
            LogManager logManager = LogManager.getLogManager();
            logManager.readConfiguration(input);

            // Cargar la configuración adicional
            CustomFormatter.show_logger_name = Boolean.valueOf(logManager.getProperty("formatter.show_logger_name"));
            CustomFormatter.show_instance = Boolean.valueOf(logManager.getProperty("formatter.show_instance"));

            // Configurar el ConsoleHandler para el logger global
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(Level.INFO); // Asegúrate de que el nivel sea INFO o mayor
            consoleHandler.setFormatter(new CustomFormatter());

            // Asigna el handler al logger principal si aún no lo tiene
            Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            if (!Arrays.asList(logger.getHandlers()).contains(consoleHandler)) {
                logger.addHandler(consoleHandler);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public CustomLogger(String name, String resourceBundleName) {
        super(name, null);
    }

    public void severe(Collection<String> messages) {
        messages.forEach(message -> super.severe(message));
    }

    public void warning(Collection<String> messages) {
        messages.forEach(message -> super.warning(message));
    }

    public static Logger getCustomLogger(String name) {
        return (Logger) new CustomLogger(name, null);
    }

}

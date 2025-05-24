package com.jannotate.common.utils;

import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.jannotate.common.enums.NotificationType;

public class NotificationUtils {

    public static ActionListener showMessage(String message, String title, NotificationType notificationType) {
        return e -> JOptionPane.showMessageDialog(null, message, title, notificationType.getValue());
    }

    public static ActionListener showError(String message, String title) {
        return showMessage(message, title, NotificationType.ERROR);
    }

    public static ActionListener showInfo(String message, String title) {
        return showMessage(message, title, NotificationType.INFORMATION);
    }

    public static ActionListener showPlain(String message, String title) {
        return showMessage(message, title, NotificationType.PLAIN);
    }

    public static ActionListener showWarning(String message, String title) {
        return showMessage(message, title, NotificationType.WARNING);
    }

    public static ActionListener showQuestion(String message, String title) {
        return showMessage(message, title, NotificationType.QUESTION);
    }

}

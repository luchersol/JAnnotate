package com.jannotate.common.utils;

import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

import com.jannotate.common.enums.NotificationType;
import com.jannotate.common.enums.QuestionType;

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

    public static ActionListener showQuestionCustom(String message, String title, QuestionType questionType,
            String[] optionTitles, Method[] optionFunctions, Object object) {
        return e -> {
            int result = JOptionPane.showOptionDialog(
                    null,
                    "¿Quieres guardar los cambios?",
                    "Confirmar salida",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    optionTitles,
                    optionTitles[0]);
            try {
                optionFunctions[result].invoke(object);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        };
    }

    public static ActionListener showQuestion(String message, String title, QuestionType questionType,
            Method okFunction, Method noFunction, Method cancelFunction, Method closedFunction, Object object) {
        return e -> {
            int result = JOptionPane.showConfirmDialog(null, message, title, questionType.getValue());
            try {
                switch (result) {
                    case JOptionPane.YES_OPTION -> {
                        if (okFunction != null)
                            okFunction.invoke(object);
                    }
                    case JOptionPane.NO_OPTION -> {
                        if (noFunction != null)
                            noFunction.invoke(object);
                    }
                    case JOptionPane.CANCEL_OPTION -> {
                        if (cancelFunction != null)
                            cancelFunction.invoke(object);
                    }
                    case JOptionPane.CLOSED_OPTION -> {
                        if (closedFunction != null)
                            closedFunction.invoke(object);
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e1) {
                e1.printStackTrace();
            }
        };
    }

}

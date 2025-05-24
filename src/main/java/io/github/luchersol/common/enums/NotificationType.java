package io.github.luchersol.common.enums;

import javax.swing.JOptionPane;

public enum NotificationType {
    ERROR(JOptionPane.ERROR_MESSAGE),
    INFORMATION(JOptionPane.INFORMATION_MESSAGE),
    WARNING(JOptionPane.WARNING_MESSAGE),
    PLAIN(JOptionPane.PLAIN_MESSAGE);

    private int value;

    NotificationType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}

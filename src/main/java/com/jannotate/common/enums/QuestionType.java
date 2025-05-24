package com.jannotate.common.enums;

import javax.swing.JOptionPane;

public enum QuestionType {
    YES_NO_OPTION(JOptionPane.YES_NO_OPTION),
    YES_NO_CANCEL_OPTION(JOptionPane.YES_NO_CANCEL_OPTION),
    OK_CANCEL_OPTION(JOptionPane.OK_CANCEL_OPTION),
    CUSTOM(3);

    private int value;

    QuestionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}

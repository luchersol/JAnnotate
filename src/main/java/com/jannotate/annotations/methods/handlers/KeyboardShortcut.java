package com.jannotate.annotations.methods.handlers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.swing.JComponent;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface KeyboardShortcut {
    String value();

    String name();

    String[] args() default {};

    boolean onKeyRelease() default false;

    boolean introduce_abstract_action() default false;

    /**
     * one of JComponent.WHEN_IN_FOCUSED_WINDOW, JComponent.WHEN_FOCUSED,
     * JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT
     * <br>
     */
    int condition() default JComponent.WHEN_FOCUSED;

}

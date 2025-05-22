package com.jannotate.annotations.methods.handlers.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.input.PopupMenuListenerHandlers;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(PopupMenuListenerHandlers.class)
public @interface PopupMenuListenerHandler {
    String value();

    String[] args() default {};
}

package com.jannotate.annotations.methods.handlers.single.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.scroll.ChangeListenerHandlers;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ChangeListenerHandlers.class)
public @interface ChangeListenerHandler {
    String value();

    String[] args() default {};
}

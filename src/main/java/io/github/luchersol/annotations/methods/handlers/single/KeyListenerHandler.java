package com.jannotate.annotations.methods.handlers.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.KeyListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(KeyListenerHandlers.class)
public @interface KeyListenerHandler {

    String value();

    String[] args() default {};

}

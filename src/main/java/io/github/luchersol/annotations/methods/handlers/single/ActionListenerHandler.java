package io.github.luchersol.annotations.methods.handlers.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.ActionListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ActionListenerHandlers.class)
public @interface ActionListenerHandler {

    String value();

    String[] args() default {};

}

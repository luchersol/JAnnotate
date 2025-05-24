package io.github.luchersol.annotations.methods.handlers.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.input.MenuKeyListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MenuKeyListenerHandlers.class)
public @interface MenuKeyListenerHandler {
    String value();

    String[] args() default {};

}

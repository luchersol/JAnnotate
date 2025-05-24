package io.github.luchersol.annotations.methods.handlers.single.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.input.MenuListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MenuListenerHandlers.class)
public @interface MenuListenerHandler {
    String value();

    String[] args() default {};
}

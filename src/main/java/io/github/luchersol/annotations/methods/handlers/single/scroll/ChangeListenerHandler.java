package io.github.luchersol.annotations.methods.handlers.single.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.scroll.ChangeListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ChangeListenerHandlers.class)
public @interface ChangeListenerHandler {
    String value();

    String[] args() default {};
}

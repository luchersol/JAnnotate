package io.github.luchersol.annotations.methods.handlers.single.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.mouse.MouseListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MouseListenerHandlers.class)
public @interface MouseListenerHandler {
    String value() default "";

    String[] args() default {};

}

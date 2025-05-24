package io.github.luchersol.annotations.methods.handlers.single.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.mouse.MouseWheelListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MouseWheelListenerHandlers.class)
public @interface MouseWheelListenerHandler {

    String value();

    String[] args() default {};

}

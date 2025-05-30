package io.github.luchersol.annotations.methods.handlers.single.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.scroll.ItemListenerHandlers;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(ItemListenerHandlers.class)
public @interface ItemListenerHandler {
    String value();

    String[] args() default {};
}

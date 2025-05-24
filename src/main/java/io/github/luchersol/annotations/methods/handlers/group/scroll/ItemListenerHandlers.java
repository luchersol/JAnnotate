package io.github.luchersol.annotations.methods.handlers.group.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.single.scroll.ItemListenerHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ItemListenerHandlers {
  ItemListenerHandler[] value() default {};
}

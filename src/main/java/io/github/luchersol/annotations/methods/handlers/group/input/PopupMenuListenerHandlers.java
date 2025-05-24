package io.github.luchersol.annotations.methods.handlers.group.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.single.input.PopupMenuListenerHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PopupMenuListenerHandlers {
  PopupMenuListenerHandler[] value() default {};
}

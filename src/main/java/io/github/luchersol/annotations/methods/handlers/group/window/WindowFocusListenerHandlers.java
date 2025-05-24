package io.github.luchersol.annotations.methods.handlers.group.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.single.window.WindowFocusListenerHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WindowFocusListenerHandlers {
  WindowFocusListenerHandler[] value() default {};
}

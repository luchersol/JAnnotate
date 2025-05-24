package io.github.luchersol.annotations.methods.handlers.group.mouse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.single.mouse.MouseWheelListenerHandler;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MouseWheelListenerHandlers {
  MouseWheelListenerHandler[] value() default {};
}

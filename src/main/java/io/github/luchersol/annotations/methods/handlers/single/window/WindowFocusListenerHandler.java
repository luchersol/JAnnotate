package io.github.luchersol.annotations.methods.handlers.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.annotations.methods.handlers.group.window.WindowFocusListenerHandlers;
import io.github.luchersol.common.annotations.MethodAndArgs;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(WindowFocusListenerHandlers.class)
public @interface WindowFocusListenerHandler {
    MethodAndArgs onWindowGainedFocus() default @MethodAndArgs();

    MethodAndArgs onWindowLostFocus() default @MethodAndArgs();
}

package com.jannotate.annotations.methods.handlers.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.window.WindowFocusListenerHandlers;
import com.jannotate.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(WindowFocusListenerHandlers.class)
public @interface WindowFocusListenerHandler {
    MethodAndArgs onWindowGainedFocus() default @MethodAndArgs();

    MethodAndArgs onWindowLostFocus() default @MethodAndArgs();
}

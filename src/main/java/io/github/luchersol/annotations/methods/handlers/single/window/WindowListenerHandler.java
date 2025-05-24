package com.jannotate.annotations.methods.handlers.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.group.window.WindowListenerHandlers;
import com.jannotate.common.annotations.MethodAndArgs;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(WindowListenerHandlers.class)
public @interface WindowListenerHandler {
    MethodAndArgs onWindowOpened() default @MethodAndArgs();

    MethodAndArgs onWindowClosing() default @MethodAndArgs();

    MethodAndArgs onWindowClosed() default @MethodAndArgs();

    MethodAndArgs onWindowIconified() default @MethodAndArgs();

    MethodAndArgs onWindowDeiconified() default @MethodAndArgs();

    MethodAndArgs onWindowActivated() default @MethodAndArgs();

    MethodAndArgs onWindowDeactivated() default @MethodAndArgs();

}

package com.jannotate.annotations.fields.listeners.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddWindowListener {
    MethodAndArgs onWindowOpened() default @MethodAndArgs();

    MethodAndArgs onWindowClosing() default @MethodAndArgs();

    MethodAndArgs onWindowClosed() default @MethodAndArgs();

    MethodAndArgs onWindowIconified() default @MethodAndArgs();

    MethodAndArgs onWindowDeiconified() default @MethodAndArgs();

    MethodAndArgs onWindowActivated() default @MethodAndArgs();

    MethodAndArgs onWindowDeactivated() default @MethodAndArgs();

}

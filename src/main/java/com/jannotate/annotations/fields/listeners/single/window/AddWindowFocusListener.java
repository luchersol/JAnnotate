package com.jannotate.annotations.fields.listeners.single.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.annotations.MethodAndArgs;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddWindowFocusListener {
    MethodAndArgs onWindowGainedFocus() default @MethodAndArgs();

    MethodAndArgs onWindowLostFocus() default @MethodAndArgs();
}

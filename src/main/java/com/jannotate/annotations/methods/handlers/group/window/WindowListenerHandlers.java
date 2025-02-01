package com.jannotate.annotations.methods.handlers.group.window;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.single.window.WindowListenerHandler;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WindowListenerHandlers {
    WindowListenerHandler[] value() default {};

}

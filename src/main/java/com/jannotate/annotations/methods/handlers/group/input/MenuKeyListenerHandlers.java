package com.jannotate.annotations.methods.handlers.group.input;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.methods.handlers.single.input.MenuKeyListenerHandler;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MenuKeyListenerHandlers {
    MenuKeyListenerHandler[] value() default {};
}

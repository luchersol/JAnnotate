package com.jannotate.annotations.methods.handlers.group.input;

import com.jannotate.annotations.methods.handlers.single.input.PopupMenuListenerHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PopupMenuListenerHandlers {
  PopupMenuListenerHandler[] value() default {};
}

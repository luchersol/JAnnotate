package com.jannotate.annotations.methods.handlers.group.mouse;

import com.jannotate.annotations.methods.handlers.single.mouse.MouseListenerHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MouseListenerHandlers {
  MouseListenerHandler[] value() default {};
}

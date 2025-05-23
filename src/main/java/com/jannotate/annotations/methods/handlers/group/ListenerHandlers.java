package com.jannotate.annotations.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.single.ListenerHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ListenerHandlers {
  ListenerHandler[] value() default {};
}

package com.jannotate.annotations.methods.handlers.group.scroll;

import com.jannotate.annotations.methods.handlers.single.scroll.ChangeListenerHandler;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ChangeListenerHandlers {
  ChangeListenerHandler[] value() default {};
}

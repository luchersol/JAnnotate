package com.jannotate.annotations.fields.listeners.group.window;

import com.jannotate.annotations.fields.listeners.single.window.AddWindowStateListener;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddWindowStateListeners {
  AddWindowStateListener[] value() default {};
}

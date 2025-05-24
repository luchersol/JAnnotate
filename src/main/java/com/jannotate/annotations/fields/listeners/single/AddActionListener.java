package com.jannotate.annotations.fields.listeners.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.fields.listeners.group.AddActionListeners;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(AddActionListeners.class)
public @interface AddActionListener {

    String value();

    String[] args() default {};

    Class<?>[] type_args() default {};

}

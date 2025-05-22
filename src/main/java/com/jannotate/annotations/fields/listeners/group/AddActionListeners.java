package com.jannotate.annotations.fields.listeners.group;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.annotations.fields.listeners.single.AddActionListener;
import com.jannotate.common.annotations.ContainerAnnotation;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@ContainerAnnotation(AddActionListener.class)
public @interface AddActionListeners {

    AddActionListener[] value() default {};

}

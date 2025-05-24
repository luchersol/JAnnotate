package com.jannotate.annotations.mixed.fields_classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.swing.JFrame;

@Target({ ElementType.FIELD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface SetDefaultClose {
    int value() default JFrame.HIDE_ON_CLOSE;
}

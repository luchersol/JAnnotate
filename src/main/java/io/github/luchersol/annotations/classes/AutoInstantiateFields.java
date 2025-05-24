package io.github.luchersol.annotations.classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import io.github.luchersol.common.annotations.PriorityAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@PriorityAnnotation
public @interface AutoInstantiateFields {
    boolean recursive() default false;
}

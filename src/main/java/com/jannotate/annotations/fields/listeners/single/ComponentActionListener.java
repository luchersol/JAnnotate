package com.jannotate.annotations.fields.listeners.single;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ComponentActionListener {
    
    String method() default "";
    String[] args() default {};
    Class<?>[] type_args() default {};
    
}

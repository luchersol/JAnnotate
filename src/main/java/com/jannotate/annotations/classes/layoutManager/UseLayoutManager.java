package com.jannotate.annotations.classes.layoutManager;

import java.awt.LayoutManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseLayoutManager {
    Class<? extends LayoutManager> value() default java.awt.FlowLayout.class;
}

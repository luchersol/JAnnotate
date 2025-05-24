package com.jannotate.annotations.classes.layoutManager;

import java.awt.FlowLayout;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseFlowLayout {
    int align() default FlowLayout.CENTER;
    int hgap() default 5;
    int vgap() default 5;
}

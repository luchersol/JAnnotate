package io.github.luchersol.annotations.classes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.swing.JFrame;

import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.common.annotations.PriorityAnnotation;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@PriorityAnnotation
public @interface AutoSetup {

    boolean recursiveAutoInstatiate() default false;

    boolean isVisible() default true;

    UseFlowLayout layout() default @UseFlowLayout;

    int defaultClose() default JFrame.HIDE_ON_CLOSE;

    SetSize size() default @SetSize;

    String title() default "";
}

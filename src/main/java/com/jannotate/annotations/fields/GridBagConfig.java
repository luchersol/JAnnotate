package com.jannotate.annotations.fields;

import java.awt.GridBagConstraints;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.jannotate.common.annotations.InsetsAnnotation;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GridBagConfig {
    int gridx() default GridBagConstraints.RELATIVE;
    int gridy() default GridBagConstraints.RELATIVE;
    int gridwidth() default 1;
    int gridheight() default 1;

    int weightx() default 0;
    int weighty() default 0;

    int anchor() default GridBagConstraints.CENTER;
    int fill() default GridBagConstraints.NONE;

    InsetsAnnotation insets() default @InsetsAnnotation();
    int ipadx() default 0;
    int ipady() default 0;

}

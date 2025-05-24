package io.github.luchersol.annotations.fields;

import java.awt.BorderLayout;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface BorderPosition {
    String value() default BorderLayout.CENTER;
}

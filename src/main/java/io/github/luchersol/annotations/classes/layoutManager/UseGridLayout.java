package io.github.luchersol.annotations.classes.layoutManager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseGridLayout {
    int rows() default 1;

    int cols() default 0;

    int hgap() default 0;

    int vgap() default 0;
}

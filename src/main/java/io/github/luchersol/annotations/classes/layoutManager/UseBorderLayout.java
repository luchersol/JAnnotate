package io.github.luchersol.annotations.classes.layoutManager;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface UseBorderLayout {
    int hgap() default 0;

    int vgap() default 0;
}

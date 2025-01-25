package src.annotations.classes;

import java.awt.LayoutManager;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LayoutManagerAnnotation {
    Class<? extends LayoutManager> value() default java.awt.FlowLayout.class;  // Usando FlowLayout como valor por defecto
}

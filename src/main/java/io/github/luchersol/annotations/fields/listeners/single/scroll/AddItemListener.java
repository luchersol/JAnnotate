package io.github.luchersol.annotations.fields.listeners.single.scroll;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AddItemListener {
    String value();

    String[] args() default {};

    Class<?>[] type_args() default {};
}

package io.github.luchersol.common.utils;

import java.lang.annotation.Annotation;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;

public final class AnnotationMocks {

    private AnnotationMocks() {
    }

    public static AutoInstantiateFields autoInstantiateFields(boolean recursive) {
        return new AutoInstantiateFields() {
            @Override
            public boolean recursive() {
                return recursive;
            }

            @Override
            public Class<? extends Annotation> annotationType() {
                return AutoInstantiateFields.class;
            }
        };
    }

    public static AutoAddComponents autoAddComponents() {
        return new AutoAddComponents() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return AutoAddComponents.class;
            }
        };
    }

    public static IsVisible isVisible(boolean isVisible) {
        return new IsVisible() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return IsVisible.class;
            }

            @Override
            public boolean value() {
                return isVisible;
            }
        };
    }

    public static SetTitle setTitle(String title) {
        return new SetTitle() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return SetTitle.class;
            }

            @Override
            public String value() {
                return title;
            }
        };
    }

    public static SetDefaultClose setDefaultClose(int value) {
        return new SetDefaultClose() {
            @Override
            public Class<? extends Annotation> annotationType() {
                return SetDefaultClose.class;
            }

            @Override
            public int value() {
                return value;
            }
        };
    }

}

package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jannotate.common.interfaces.FieldProcessorInterface;

public abstract class AbstractGroupedListenerProcessor<P extends AbstractListenerProcessor<S>, S extends Annotation, G extends Annotation> implements FieldProcessorInterface {

    public abstract Class<P> getProcessorClass();

    public abstract Class<S> getAnnotationSingleClass();

    public abstract Class<G> getAnnotationGroupClass();

    @SuppressWarnings("unchecked")
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(getAnnotationGroupClass())) {
            G groupAnnotations = field.getAnnotation(getAnnotationGroupClass());
            try {
                Method value = groupAnnotations.annotationType().getMethod("value");
                Object result = value.invoke(groupAnnotations);
                if (result instanceof Object[]) {
                    S[] actions = (S[]) result;
                    for (S actionComponent : actions) {
                        P instance = getProcessorClass().getDeclaredConstructor().newInstance();
                        instance.bindSwingListener(field, object, actionComponent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
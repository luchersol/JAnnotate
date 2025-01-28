package com.jannotate.common;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.jannotate.annotations.fields.listeners.group.ComponentActionListeners;

// <Processor, Annotation>
public abstract class AbstractGroupedListenerProcessor<P extends AbstractListenerProcessor<L>, L extends Annotation, G extends Annotation> implements FieldProcessorInterface {

    public abstract Class<P> getProcessorClass();

    public abstract Class<L> getAnnotationSingleClass();

    public abstract Class<G> getAnnotationGroupClass();

    @SuppressWarnings("unchecked")
    public void process(Field field, Object object) {
        if (field.isAnnotationPresent(ComponentActionListeners.class)) {
            G groupAnnotations = field.getAnnotation(getAnnotationGroupClass());
            try {
                Method method = groupAnnotations.annotationType().getMethod("actions");
                Object result = method.invoke(groupAnnotations);
                if (result instanceof Object[]) {
                    L[] actions = (L[]) result;
                    for (L actionComponent : actions) {
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
package com.jannotate.common.abstractClasses;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import com.jannotate.common.interfaces.MethodProcessorInterface;

public abstract class AbstractGroupedListenerHandlerProcessor<P extends AbstractListenerHandlerProcessor<S>, S extends Annotation, G extends Annotation> implements MethodProcessorInterface {

    public abstract Class<P> getProcessorClass();

    public abstract Class<S> getAnnotationSingleClass();

    public abstract Class<G> getAnnotationGroupClass();

    @SuppressWarnings("unchecked")
    public void process(Method method, Object object) {
        if (method.isAnnotationPresent(getAnnotationGroupClass())) {
            G groupAnnotations = method.getAnnotation(getAnnotationGroupClass());
            try {
                Method value = groupAnnotations.annotationType().getMethod("value");
                Object result = value.invoke(groupAnnotations);
                if (result instanceof Object[]) {
                    S[] actions = (S[]) result;
                    for (S actionComponent : actions) {
                        P instance = getProcessorClass().getDeclaredConstructor().newInstance();
                        instance.bindSwingListenerHandler(method, object, actionComponent);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

}
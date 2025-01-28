package com.jannotate.processors.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.group.ComponentActionListeners;
import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.fields.listeners.single.ComponentActionListenerProcessor;

@JProcessor
public class ComponentActionListenersProcessor extends AbstractGroupedListenerProcessor<ComponentActionListenerProcessor, ComponentActionListener, ComponentActionListeners> {

    @Override
    public Class<ComponentActionListenerProcessor> getProcessorClass() {
        return ComponentActionListenerProcessor.class;
    }

    @Override
    public Class<ComponentActionListener> getAnnotationSingleClass() {
        return ComponentActionListener.class;
    }

    @Override
    public Class<ComponentActionListeners> getAnnotationGroupClass() {
        return ComponentActionListeners.class;
    }

}

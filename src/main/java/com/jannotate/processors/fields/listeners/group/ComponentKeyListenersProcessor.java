package com.jannotate.processors.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.group.ComponentKeyListeners;
import com.jannotate.annotations.fields.listeners.single.ComponentKeyListener;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.fields.listeners.single.ComponentKeyListenerProcessor;

@JProcessor
public class ComponentKeyListenersProcessor extends
                AbstractGroupedListenerProcessor<ComponentKeyListenerProcessor, ComponentKeyListener, ComponentKeyListeners> {

}

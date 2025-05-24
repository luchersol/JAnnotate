package com.jannotate.processors.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.group.AddKeyListeners;
import com.jannotate.annotations.fields.listeners.single.AddKeyListener;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.fields.listeners.single.AddKeyListenerProcessor;

@JProcessor
public class AddKeyListenersProcessor extends AbstractGroupedListenerProcessor<AddKeyListenerProcessor, AddKeyListener, AddKeyListeners> {
}

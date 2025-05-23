package com.jannotate.processors.fields.listeners.group;

import com.jannotate.annotations.fields.listeners.group.AddActionListeners;
import com.jannotate.annotations.fields.listeners.single.AddActionListener;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.fields.listeners.single.AddActionListenerProcessor;

@JProcessor
public class AddActionListenersProcessor extends AbstractGroupedListenerProcessor<AddActionListenerProcessor, AddActionListener, AddActionListeners> {
}

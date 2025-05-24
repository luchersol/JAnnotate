package io.github.luchersol.processors.fields.listeners.group;

import io.github.luchersol.annotations.fields.listeners.group.AddActionListeners;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.fields.listeners.single.AddActionListenerProcessor;

@JProcessor
public class AddActionListenersProcessor
                extends
                AbstractGroupedListenerProcessor<AddActionListenerProcessor, AddActionListener, AddActionListeners> {
}

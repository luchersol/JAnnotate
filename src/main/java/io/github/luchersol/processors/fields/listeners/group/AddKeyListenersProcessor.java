package io.github.luchersol.processors.fields.listeners.group;

import io.github.luchersol.annotations.fields.listeners.group.AddKeyListeners;
import io.github.luchersol.annotations.fields.listeners.single.AddKeyListener;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.fields.listeners.single.AddKeyListenerProcessor;

@JProcessor
public class AddKeyListenersProcessor
                extends AbstractGroupedListenerProcessor<AddKeyListenerProcessor, AddKeyListener, AddKeyListeners> {
}

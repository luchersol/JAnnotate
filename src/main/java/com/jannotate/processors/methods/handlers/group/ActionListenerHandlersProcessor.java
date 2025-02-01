package com.jannotate.processors.methods.handlers.group;

import com.jannotate.annotations.methods.handlers.group.ActionListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.ActionListenerHandler;
import com.jannotate.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import com.jannotate.common.annotations.JProcessor;
import com.jannotate.processors.methods.handlers.single.ActionListenerHandlerProcessor;

@JProcessor
public class ActionListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<ActionListenerHandlerProcessor, ActionListenerHandler, ActionListenerHandlers> {
}

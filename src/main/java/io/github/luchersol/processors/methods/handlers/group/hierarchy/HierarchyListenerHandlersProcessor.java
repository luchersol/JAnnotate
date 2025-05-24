package io.github.luchersol.processors.methods.handlers.group.hierarchy;

import io.github.luchersol.annotations.methods.handlers.group.hierarchy.HierarchyListenerHandlers;
import io.github.luchersol.annotations.methods.handlers.single.hierarchy.HierarchyListenerHandler;
import io.github.luchersol.common.abstractClasses.AbstractGroupedListenerHandlerProcessor;
import io.github.luchersol.common.annotations.JProcessor;
import io.github.luchersol.processors.methods.handlers.single.hierarchy.HierarchyListenerHandlerProcessor;

@JProcessor
public class HierarchyListenerHandlersProcessor extends
                AbstractGroupedListenerHandlerProcessor<HierarchyListenerHandlerProcessor, HierarchyListenerHandler, HierarchyListenerHandlers> {
}

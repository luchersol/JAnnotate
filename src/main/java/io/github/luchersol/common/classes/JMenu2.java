package io.github.luchersol.common.classes;

import javax.swing.JMenu;

import io.github.luchersol.common.AnnotationProcessorProxy;
import io.github.luchersol.common.interfaces.MyFrameInterface;

public class JMenu2 extends JMenu implements MyFrameInterface {

    public JMenu2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

package io.github.luchersol.common.classes;

import javax.swing.JMenuBar;

import io.github.luchersol.common.AnnotationProcessorProxy;
import io.github.luchersol.common.interfaces.MyFrameInterface;

public class JMenuBar2 extends JMenuBar implements MyFrameInterface {

    public JMenuBar2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

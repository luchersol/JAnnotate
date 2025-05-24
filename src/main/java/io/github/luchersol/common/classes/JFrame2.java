package io.github.luchersol.common.classes;

import javax.swing.JFrame;

import io.github.luchersol.common.AnnotationProcessorProxy;
import io.github.luchersol.common.interfaces.MyFrameInterface;

public class JFrame2 extends JFrame implements MyFrameInterface {

    public JFrame2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

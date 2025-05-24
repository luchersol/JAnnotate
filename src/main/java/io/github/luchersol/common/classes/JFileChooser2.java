package io.github.luchersol.common.classes;

import javax.swing.JFileChooser;

import io.github.luchersol.common.AnnotationProcessorProxy;
import io.github.luchersol.common.interfaces.MyFrameInterface;

public class JFileChooser2 extends JFileChooser implements MyFrameInterface {

    public JFileChooser2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

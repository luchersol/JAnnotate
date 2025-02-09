package com.jannotate.common.classes;

import javax.swing.JFileChooser;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public class JFileChooser2 extends JFileChooser implements MyFrameInterface {

    public JFileChooser2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

package com.jannotate.common.classes;

import javax.swing.JFrame;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public class JFrame2 extends JFrame implements MyFrameInterface {

    public JFrame2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

package com.jannotate.common.classes;

import javax.swing.JMenuBar;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public class JMenuBar2 extends JMenuBar implements MyFrameInterface {

    public JMenuBar2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

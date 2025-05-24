package com.jannotate.common.classes;

import javax.swing.JMenu;

import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.interfaces.MyFrameInterface;

public class JMenu2 extends JMenu implements MyFrameInterface {

    public JMenu2() {
        AnnotationProcessorProxy.createProxy(this);
    }

}

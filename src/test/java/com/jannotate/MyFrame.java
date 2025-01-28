package com.jannotate;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.IsVisible;
import com.jannotate.annotations.classes.layoutManager.UseBorderLayout;
import com.jannotate.annotations.fields.BorderPosition;
import com.jannotate.annotations.fields.GridBagConfig;
import com.jannotate.annotations.fields.SetSize;
import com.jannotate.annotations.fields.SetText;
import com.jannotate.annotations.fields.listeners.group.ComponentActionListeners;
import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.annotations.methods.ActionListenerHandlers;
import com.jannotate.common.AnnotationProcessorProxy;
import com.jannotate.common.enums.TextColor;
import com.jannotate.common.interfaces.MyFrameInterface;

@AutoInstantiateFields
@AutoAddComponents
@UseBorderLayout
@IsVisible
public class MyFrame extends JFrame implements MyFrameInterface {

    // @ComponentActionListeners({
    //         @ComponentActionListener(method = "printBoton"),
    //         @ComponentActionListener(method = "mostrarAlerta") 
    // })
    @BorderPosition(BorderLayout.SOUTH)
    @SetText(text = "Click", color = TextColor.BLUE)
    private JButton myButton;

    @BorderPosition(BorderLayout.NORTH)
    @SetText(text = "Hola")
    private JTextField myTextField;

    @ActionListenerHandlers({
            @ActionListenerHandler(component = "myButton", args = { "1" }),
            @ActionListenerHandler(component = "myTextField", args = { "2" })
    })
    public static ActionListener metodoActionListener(int i) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ACTION LISTENER " + i);
            }
        };
    }

    public static void printBoton() {
        System.out.println("Presionaste el botón");
    }

    public void mostrarAlerta() {
        JOptionPane.showMessageDialog(this, "¡Este es un mensaje de alerta!", "Alerta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public MyFrame() {
        AnnotationProcessorProxy.createProxy(this);
        this.setSize(500, 500);
        // this.setExtendedState(JFrame.NORMAL);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MyFrame.run();
    }

    public static MyFrame run() {
        return new MyFrame();
    }

}
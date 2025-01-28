package com.jannotate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jannotate.annotations.MyFrameInterface;
import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.IsVisible;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.SetBound;
import com.jannotate.annotations.fields.SetSize;
import com.jannotate.annotations.fields.SetText;
import com.jannotate.annotations.fields.listeners.group.ComponentActionListeners;
import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.annotations.methods.ActionListenerHandlers;
import com.jannotate.common.TextColor;
import com.jannotate.processors.AnnotationProcessorProxy;

@AutoInstantiateFields
@AutoAddComponents
@UseFlowLayout
@IsVisible
public class MyFrame extends JFrame implements MyFrameInterface {

    @ComponentActionListeners(actions = {
            @ComponentActionListener(method = "printBoton"),
            @ComponentActionListener(method = "mostrarAlerta") 
    })
    @SetSize(width = 100, heigth = 40)
    @SetText(text = "Click", color = TextColor.BLUE)
    private JButton myButton;

    @SetBound(x = 0, y = 0, heigth = 300, width = 100)
    @SetText(text = "Hola")
    private JTextField myTextField;

    @SetSize(width = 300, heigth = 50)
    private JPasswordField myPasswordField;

    public MyFrame() {
        AnnotationProcessorProxy.createProxy(this);
        this.setSize(500, 500);
        // this.setExtendedState(JFrame.NORMAL);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @ActionListenerHandlers(actions = {
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

    public static void main(String[] args) {
        MyFrame.run();
    }

    public static MyFrame run() {
        return new MyFrame();
    }

}
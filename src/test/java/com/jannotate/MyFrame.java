package com.jannotate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jannotate.annotations.MyFrameInterface;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.FlowLayoutAnnotation;
import com.jannotate.annotations.fields.ActionComponent;
import com.jannotate.annotations.fields.ActionsComponent;
import com.jannotate.annotations.fields.AutoAdd;
import com.jannotate.annotations.fields.SizeComponent;
import com.jannotate.annotations.fields.TextComponent;
import com.jannotate.processors.AnnotationProcessorProxy;

@AutoInstantiateFields
@FlowLayoutAnnotation
public class MyFrame extends JFrame implements MyFrameInterface {

    @AutoAdd
    @ActionsComponent(actions = { @ActionComponent(method = "printBoton"),  @ActionComponent(method = "mostrarAlerta")})
    @SizeComponent(width = 100, heigth = 40)
    @TextComponent(text = "Click")
    private JButton myButton;

    @AutoAdd
    @SizeComponent(width = 300, heigth = 50)
    @TextComponent(text = "Hola")
    private JTextField myTextField;

    @AutoAdd
    @SizeComponent(width = 300, heigth = 50)
    private JPasswordField myPasswordField;

    public MyFrame() { 
        AnnotationProcessorProxy.createProxy(this).applyAnnotations();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }

    public static void printBoton(){
        System.out.println("Presionaste el botón");
    }

    public void mostrarAlerta(){
        JOptionPane.showMessageDialog(this, "¡Este es un mensaje de alerta!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}
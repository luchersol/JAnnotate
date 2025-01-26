package com.jannotate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.jannotate.annotations.MyFrameInterface;
import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.ActionMethod;
import com.jannotate.annotations.fields.ActionMethods;
import com.jannotate.annotations.fields.SetSize;
import com.jannotate.annotations.fields.SetText;
import com.jannotate.processors.AnnotationProcessorProxy;

@AutoInstantiateFields
@AutoAddComponents
@UseFlowLayout
public class MyFrame extends JFrame implements MyFrameInterface {

    @ActionMethods(actions = { @ActionMethod(method = "printBoton"),  @ActionMethod(method = "mostrarAlerta")})
    @SetSize(width = 100, heigth = 40)
    @SetText(text = "Click")
    private JButton myButton;

    @SetSize(width = 300, heigth = 50)
    @SetText(text = "Hola")
    private JTextField myTextField;

    @SetSize(width = 300, heigth = 50)
    private JPasswordField myPasswordField;

    public MyFrame() { 
        AnnotationProcessorProxy.createProxy(this).applyAnnotations();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
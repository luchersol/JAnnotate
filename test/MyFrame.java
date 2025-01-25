package test;

import java.awt.*;
import java.util.function.Consumer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import src.annotations.ActionComponent;
import src.annotations.ActionsComponent;
import src.annotations.AnnotationProcessorProxy;
import src.annotations.AutoAdd;
import src.annotations.AutoInstantiateFields;
import src.annotations.MyFrameInterface;
import src.annotations.SizeComponent;

@AutoInstantiateFields
public class MyFrame extends JFrame implements MyFrameInterface {

    @AutoAdd
    @ActionsComponent(actions = {
        @ActionComponent(method = "printBoton"),
        @ActionComponent(method = "mostrarAlerta")
    })
    @SizeComponent(width = 20, heigth = 100)
    private JButton myButton;

    @AutoAdd
    @SizeComponent(width = 300, heigth = 50)
    private JTextField myTextField;

    public MyFrame() {    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        MyFrameInterface proxyFrame = (MyFrameInterface) AnnotationProcessorProxy.createProxy(this);
        proxyFrame.setVisible(true);
        
        this.pack();
        this.setVisible(true);
    }

    public static void printBoton(){
        System.out.println("Presionaste el botón");
    }

    public void mostrarAlerta(){
         JOptionPane.showMessageDialog(this, "¡Este es un mensaje de alerta!", "Alerta", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void run(){
        new MyFrame();
    }

    public static void main(String[] args) {
        MyFrame.run();
    }
}
package com.jannotate;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.BorderPosition;
import com.jannotate.annotations.fields.listeners.group.ComponentActionListeners;
import com.jannotate.annotations.fields.listeners.single.ComponentActionListener;
import com.jannotate.annotations.methods.ActionListenerHandler;
import com.jannotate.annotations.methods.ActionListenerHandlers;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.common.classes.JFrame2;
import com.jannotate.common.enums.TextColor;


@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
@SetTitle("MY FRAME")
@SetSize(heigth = 500, width = 500)
public class MyFrame extends JFrame2 {

    @BorderPosition(BorderLayout.SOUTH)
    @SetText(value = "Click", color = TextColor.BLUE)
    @ComponentActionListeners({ @ComponentActionListener(method = "printBoton"),
            @ComponentActionListener(method = "mostrarAlerta") })
    JButton myButton;

    @BorderPosition(BorderLayout.NORTH)
    @SetText(value = "Hola", color = TextColor.RED)
    @SetSize(width = 100, heigth = 100)
    JTextField myTextField;

    @ActionListenerHandlers({ @ActionListenerHandler(component = "myButton", args = { "1" }),
            @ActionListenerHandler(component = "myTextField", args = { "2" }) })
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
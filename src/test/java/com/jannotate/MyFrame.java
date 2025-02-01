package com.jannotate;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.jannotate.annotations.classes.AutoAddComponents;
import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.SetImagenIcon;
import com.jannotate.annotations.fields.listeners.group.AddActionListeners;
import com.jannotate.annotations.fields.listeners.single.AddActionListener;
import com.jannotate.annotations.methods.handlers.group.ActionListenerHandlers;
import com.jannotate.annotations.methods.handlers.single.ActionListenerHandler;
import com.jannotate.annotations.methods.handlers.single.KeyListenerHandler;
import com.jannotate.annotations.methods.handlers.single.ListenerHandler;
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

    @SetText(value = "Click", color = TextColor.BLUE)
    @AddActionListeners({
            @AddActionListener(method = "printBoton"),
            @AddActionListener(method = "mostrarAlerta")
    })
    JButton jButton;

    @SetText(value = "Hola", color = TextColor.RED)
    @SetSize(width = 100, heigth = 100)
    JTextField jTextField_1;

    @SetSize(width = 100, heigth = 100)
    JTextField jTextField_2;

    @SetImagenIcon("src/main/resources/images/imagen.png")
    JLabel jLabel;

    @ActionListenerHandlers({
            @ActionListenerHandler(value = "jButton", args = { "1" }),
            @ActionListenerHandler(value = "jTextField_1", args = { "2" }),
            @ActionListenerHandler(value = "jTextField_2", args = { "3" })
    })
    public ActionListener metodoActionListener(int i) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ACTION LISTENER " + i);
            }
        };
    }

    @KeyListenerHandler(value = "jTextField_1")
    public KeyListener metodoKeyListener() {
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e.getKeyChar());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println(e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // System.out.println(e.getKeyChar());
            }
        };
    }

    @ListenerHandler(value = "jButton", type = MouseListener.class)
    public MouseListener metodoMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked en " + e.getPoint());
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("Mouse Pressed");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("Mouse Released");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("Mouse Entered");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("Mouse Exited");
            }
        };
    }

    public void printBoton() {
        System.out.println("Presionaste el botón");
    }

    public void mostrarAlerta() {
        JOptionPane.showMessageDialog(this, "¡Este es un mensaje de alerta!", "Alerta",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void printTecladoTipo() {
        System.out.println("Tecla tipo");
    }

    public void printTecladoPresionado() {
        System.out.println("Tecla pulsada");
    }

    public void printTecladoSoltado() {
        System.out.println("Tecla soltada");
    }

    public static void main(String[] args) {
        new MyFrame();
    }

}
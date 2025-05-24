package io.github.luchersol;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.fields.SetImagenIcon;
import io.github.luchersol.annotations.fields.SetPosition;
import io.github.luchersol.annotations.fields.listeners.single.AddActionListener;
import io.github.luchersol.annotations.methods.handlers.single.ActionListenerHandler;
import io.github.luchersol.annotations.methods.handlers.single.KeyListenerHandler;
import io.github.luchersol.annotations.methods.handlers.single.ListenerHandler;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.common.classes.JFrame2;
import io.github.luchersol.common.enums.TextColor;

@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
@SetTitle("MY FRAME")
@SetSize(heigth = 400, width = 500)
@SetDefaultClose(JFrame.DISPOSE_ON_CLOSE)
public class MyFrame extends JFrame2 {

    @SetText(value = "Click", color = TextColor.BLUE)
    @AddActionListener("printBoton")
    @AddActionListener("mostrarAlerta")
    private JButton jButton;

    @SetText(value = "Hola", color = TextColor.RED)
    @SetSize(width = 100, heigth = 100)
    @SetPosition(x = 0, y = 10)
    private JTextField jTextField_1;

    @SetSize(width = 100, heigth = 100)
    @SetPosition(x = 150, y = 10)
    private JTextField jTextField_2;

    @SetImagenIcon("src/main/resources/images/imagen.png")
    private JLabel jLabel;

    @ActionListenerHandler(value = "jButton", args = { "1" })
    @ActionListenerHandler(value = "jTextField_1", args = { "2" })
    @ActionListenerHandler(value = "jTextField_2", args = { "3" })
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

    public static final Random rand = new Random(1);

    @ListenerHandler(value = "jButton", type = MouseListener.class)
    public MouseListener metodoMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = rand.nextInt(getWidth() - getWidth());
                int y = rand.nextInt(getHeight() - getHeight() - 30);
                jButton.setBounds(x, y, 100, 40);
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

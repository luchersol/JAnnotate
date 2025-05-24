package io.github.luchersol.MenuTest.new_by_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.fields.AutoAdd;
import io.github.luchersol.annotations.methods.handlers.KeyboardShortcut;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetLocationRelativeTo;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetText;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.annotations.mixed.fields_classes.menu.SetJMenuBar;
import io.github.luchersol.common.classes.JFrame2;

@UseFlowLayout
@AutoInstantiateFields
@IsVisible
@SetSize(width = 500, heigth = 400)
@SetDefaultClose(JFrame.EXIT_ON_CLOSE)
@SetTitle("Ejemplo de Menú en JFrame")
@SetJMenuBar("menuBar")
@SetLocationRelativeTo
public class MenuMainClass extends JFrame2 {

    MenuBarClass menuBar;

    @AutoAdd
    @SetText("¡Bienvenido al ejemplo de menú en Swing!")
    JLabel label;

    @KeyboardShortcut(value = "ctrl X", name = "metodo", condition = JComponent.WHEN_IN_FOCUSED_WINDOW)
    public void print() {
        System.out.println("PRINT 1");
    }

    @KeyboardShortcut(value = "ctrl X", name = "metodo", condition = JComponent.WHEN_IN_FOCUSED_WINDOW, introduce_abstract_action = true)
    public AbstractAction print2() {

        return new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    System.out.println("PRINT 2");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
    }

    public static void main(String[] args) {
        new MenuMainClass();

    }

}

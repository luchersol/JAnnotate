package com.jannotate.MenuTest.new_by_class;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.classes.layoutManager.UseFlowLayout;
import com.jannotate.annotations.fields.AutoAdd;
import com.jannotate.annotations.methods.handlers.KeyboardShortcut;
import com.jannotate.annotations.mixed.fields_classes.IsVisible;
import com.jannotate.annotations.mixed.fields_classes.SetDefaultClose;
import com.jannotate.annotations.mixed.fields_classes.SetLocationRelativeTo;
import com.jannotate.annotations.mixed.fields_classes.SetSize;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.annotations.mixed.fields_classes.SetTitle;
import com.jannotate.annotations.mixed.fields_classes.menu.SetJMenuBar;
import com.jannotate.common.classes.JFrame2;

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

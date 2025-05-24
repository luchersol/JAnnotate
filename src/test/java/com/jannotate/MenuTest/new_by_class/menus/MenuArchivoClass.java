package com.jannotate.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.luchersol.annotations.classes.AutoInstantiateFields;
import com.luchersol.annotations.fields.SetAccelerator;
import com.luchersol.annotations.fields.listeners.single.AddActionListener;
import com.luchersol.annotations.mixed.fields_classes.SetText;
import com.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import com.luchersol.common.classes.JMenu2;

@SetText("Archivo")
@AddMenuItems({ "itemAbrir", "itemGuardar", "-", "itemSalir" })
@AutoInstantiateFields
public class MenuArchivoClass extends JMenu2 {

    @SetText("Abrir")
    @AddActionListener("f_abrir")
    @SetAccelerator("ctrl O")
    JMenuItem itemAbrir;

    @SetText("Guardar")
    @AddActionListener("f_guardar")
    @SetAccelerator("ctrl S")
    JMenuItem itemGuardar;

    @SetText("Salir")
    @AddActionListener("f_salir")
    @SetAccelerator("ctrl Q")
    JMenuItem itemSalir;

    public void f_abrir() {
        JOptionPane.showMessageDialog(this, "Abrir archivo...");
    }

    public void f_guardar() {
        JOptionPane.showMessageDialog(this, "Guardar archivo...");
    }

    public void f_salir() {
        System.exit(0);
    }
}

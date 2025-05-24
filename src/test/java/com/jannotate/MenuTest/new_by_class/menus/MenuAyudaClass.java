package com.jannotate.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import com.luchersol.annotations.classes.AutoInstantiateFields;
import com.luchersol.annotations.fields.listeners.single.AddActionListener;
import com.luchersol.annotations.mixed.fields_classes.SetText;
import com.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import com.luchersol.common.classes.JMenu2;

@SetText("Ayuda")
@AddMenuItems
@AutoInstantiateFields
public class MenuAyudaClass extends JMenu2 {

    @SetText("Acerca")
    @AddActionListener("f_acerca_de")
    JMenuItem itemAcercaDe;

    public void f_acerca_de() {
        JOptionPane.showMessageDialog(this, "Ejemplo de menú en Swing\nVersión 1.0");
    }
}

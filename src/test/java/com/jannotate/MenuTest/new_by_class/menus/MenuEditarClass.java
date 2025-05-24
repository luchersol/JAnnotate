package com.jannotate.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;

import com.luchersol.annotations.classes.AutoInstantiateFields;
import com.luchersol.annotations.mixed.fields_classes.SetText;
import com.luchersol.annotations.mixed.fields_classes.menu.AddMenuItems;
import com.luchersol.common.classes.JMenu2;

@SetText("Editar")
@AddMenuItems
@AutoInstantiateFields
public class MenuEditarClass extends JMenu2 {

    @SetText("Copiar")
    JMenuItem itemCopiar;

    @SetText("Pegar")
    JMenuItem itemPegar;

}

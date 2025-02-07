package com.jannotate.MenuTest.new_by_class.menus;

import javax.swing.JMenuItem;

import com.jannotate.annotations.classes.AutoInstantiateFields;
import com.jannotate.annotations.mixed.fields_classes.AddMenuItems;
import com.jannotate.annotations.mixed.fields_classes.SetText;
import com.jannotate.common.classes.JMenu2;

@SetText("Editar")
@AddMenuItems
@AutoInstantiateFields
public class MenuEditarClass extends JMenu2 {

    @SetText("Copiar")
    JMenuItem itemCopiar;

    @SetText("Pegar")
    JMenuItem itemPegar;

}

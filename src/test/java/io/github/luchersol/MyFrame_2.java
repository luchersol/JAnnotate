package io.github.luchersol;

import javax.swing.JFrame;
import javax.swing.JList;

import io.github.luchersol.annotations.classes.AutoAddComponents;
import io.github.luchersol.annotations.classes.AutoInstantiateFields;
import io.github.luchersol.annotations.classes.layoutManager.UseFlowLayout;
import io.github.luchersol.annotations.mixed.fields_classes.IsVisible;
import io.github.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import io.github.luchersol.annotations.mixed.fields_classes.SetJList;
import io.github.luchersol.annotations.mixed.fields_classes.SetSize;
import io.github.luchersol.annotations.mixed.fields_classes.SetTitle;
import io.github.luchersol.common.classes.JFrame2;

@UseFlowLayout
@AutoAddComponents
@AutoInstantiateFields
@IsVisible
@SetTitle("MY FRAME")
@SetSize(heigth = 400, width = 500)
@SetDefaultClose(JFrame.DISPOSE_ON_CLOSE)
public class MyFrame_2 extends JFrame2 {

    @SetJList({ "Opción 1", "Opción 2", "Opción 3", "Opción 4" })
    @SetSize(width = 100, heigth = 100)
    JList<String> lista;

    public static void main(String[] args) {
        new MyFrame_2();

    }
}

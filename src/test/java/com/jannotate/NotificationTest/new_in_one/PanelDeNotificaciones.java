package com.jannotate.NotificationTest.new_in_one;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.luchersol.annotations.classes.AutoAddComponents;
import com.luchersol.annotations.classes.AutoInstantiateFields;
import com.luchersol.annotations.classes.layoutManager.UseGridLayout;
import com.luchersol.annotations.fields.notifications.ShowError;
import com.luchersol.annotations.fields.notifications.ShowInfo;
import com.luchersol.annotations.fields.notifications.ShowPlain;
import com.luchersol.annotations.fields.notifications.ShowQuestion;
import com.luchersol.annotations.fields.notifications.ShowWarning;
import com.luchersol.annotations.mixed.fields_classes.IsVisible;
import com.luchersol.annotations.mixed.fields_classes.SetDefaultClose;
import com.luchersol.annotations.mixed.fields_classes.SetLocationRelativeTo;
import com.luchersol.annotations.mixed.fields_classes.SetSize;
import com.luchersol.annotations.mixed.fields_classes.SetText;
import com.luchersol.annotations.mixed.fields_classes.SetTitle;
import com.luchersol.common.classes.JFrame2;

@IsVisible
@AutoInstantiateFields
@AutoAddComponents
@SetTitle("Panel de Notificaciones")
@SetDefaultClose(JFrame.EXIT_ON_CLOSE)
@SetSize(width = 400, heigth = 300)
@SetLocationRelativeTo
@UseGridLayout(rows = 5, cols = 1, hgap = 10, vgap = 10)
public class PanelDeNotificaciones extends JFrame2 {

    @SetText("Mostrar Información")
    @ShowInfo(title = "Mostrar Información", message = "Este es un mensaje de información")
    JButton infoButton;

    @SetText("Mostrar Advertencia")
    @ShowWarning(title = "Mostrar Advertencia", message = "Este es un mensaje de advertencia")
    JButton warningButton;

    @SetText("Mostrar Error")
    @ShowError(title = "Mostrar Error", message = "Este es un mensaje de error")
    JButton errorButton;

    @SetText("Mostrar Pregunta")
    @ShowQuestion(title = "Mostrar Pregunta", message = "¿Deseas continuar?", functions = { "printYes:Si",
            "printNo:No" })
    JButton questionButton;

    @SetText("Mostrar Plano")
    @ShowPlain(title = "Mostrar Plano", message = "Mensaje plano sin icono")
    JButton plainButton;

    public void printYes() {
        System.out.println("YES");
    }

    public void printNo() {
        System.out.println("NO");
    }

    public static void main(String[] args) {
        new PanelDeNotificaciones();
    }
}

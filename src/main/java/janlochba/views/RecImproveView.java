package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "RecImprove", layout = MainView.class)
@PageTitle("Improve")
public class RecImproveView extends Div {

    private Button analysis = new Button("Improve");
    private ComboBox<String> box1 = new ComboBox<>();
    private ComboBox<String> box2 = new ComboBox<>();
    private ComboBox<String> box3 = new ComboBox<>();

    public RecImproveView(){

        // der Wert in Box1 soll an sich aus dem Issue was ausgewählt wird genommen werden

        box1.setItems("");
        box1.setPlaceholder("please select");

        // Bei box2 soll nur das angezeigt werden was nach der selektion in box1 noch möglich ist

        box2.setItems("");
        box2.setPlaceholder("please select");

        // Bei box3 soll nur das angezeigt werden was nach der selektion in box2 noch möglich ist

        box3.setItems("");
        box3.setPlaceholder("please select");

        add(createVerticalLayout());

        // clicklistener für Button einfügen mit Nachricht ... immer an diese Boy Scout Rule denken

    }

    private Component createTitle() {
        return new H3("Analysis");
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        analysis.addThemeVariants(ButtonVariant.LUMO_PRIMARY); // macht den zum Primär Button
        buttonLayout.add(analysis);
        return buttonLayout;
    }
    private Component createVerticalLayout() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.add(box1,box2,box3,analysis);

        return verticalLayout;
    }

}

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


@Route(value = "RecAnalysis", layout = MainView.class)
@PageTitle("Analysis")
public class RecAnalysisView extends Div {

    private Button analysis = new Button("analyze");
    private ComboBox<String> box1 = new ComboBox<>();
    private ComboBox<String> box2 = new ComboBox<>();

    public RecAnalysisView(){

        box1.setItems("new Project","new API","operated System");
        box1.setPlaceholder("please select");

        // Bei box2 soll nur das angezeigt werden was nach der selektion in box1 noch möglich ist

        box2.setItems("known error","code quality","data source","data","generally","requirements","HW","infrastructure","API","UI");
        box2.setPlaceholder("please select");

        add(createTitle());
        add(createVerticalLayout());
        add(createButtonLayout());

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
        verticalLayout.add(box1,box2,analysis);

        return verticalLayout;
    }

}

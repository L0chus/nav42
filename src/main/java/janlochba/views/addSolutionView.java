package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import janlochba.dto.impl.SolutionDTOImpl;


@Route(value = "add Solution", layout = MainView.class)

public class addSolutionView {
    private TextField id = new TextField("id"); // soll automatisch vergeben werden
    private TextField name = new TextField("Solution name");
    private TextField description = new TextField("Description");
    private NumberField minCost = new NumberField("min Cost");
    private NumberField maxCost = new NumberField("max Cost");

    private Button addSolution = new Button("add to Issue List");
    private Button cancel = new Button("cancel");

    private Binder<SolutionDTOImpl> binder = new Binder(SolutionDTOImpl.class);

    public addSolutionView() {

    }

    private Component createTitle() {
        return new H3("add Solution");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add( id, name, description, minCost, maxCost);
        return formLayout;
    }
    private void clearForm() {
        binder.setBean(new SolutionDTOImpl());
    }

}

package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageSolutionControl;
import janlochba.dto.impl.SolutionDTOImpl;


@Route(value = "add-Solution", layout = MainView.class)
@PageTitle("add-Solution")
public class addSolutionView extends Div {

    private TextField id = new TextField("Id");
    private TextField name = new TextField("Solution");
    private TextField description = new TextField("Description");
    private NumberField minCost = new NumberField("min Cost");
    private NumberField maxCost = new NumberField("max Cost");

    private Button save = new Button("add Solution");
    private Button cancel = new Button("cancel");

    private final Binder<SolutionDTOImpl> binder = new Binder<>(SolutionDTOImpl.class);

    public addSolutionView(ManageSolutionControl control){
        addClassName("add-Solution-view");
        add(
                new H1("add Solution"), buildForm()
        );

        binder.bindInstanceFields(this);
        clearForm();

        save.addClickListener( event -> {

            control.createSolution(binder.getBean());

            Notification.show("successfully added to Improvement Backlog");
            clearForm();
        });
    }

    private Component buildForm() {
        Div wrapper = new Div();
        wrapper.add(formLayout(),buttonLayout());
        wrapper.setWidth("75%");
        return wrapper;
    }

    private Component formLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(id, name, description, minCost , maxCost);
        return formLayout;
    }

    private void clearForm() {
        binder.setBean(new SolutionDTOImpl());
    }

    private Component buttonLayout(){
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(save,cancel);
        save.setThemeName("primary");
        return horizontalLayout;
    }



    /*private TextField id = new TextField("id");
    private TextField name = new TextField("Solution name");
    private TextField description = new TextField("Description");
    private NumberField minCost = new NumberField("min Cost");
    private NumberField maxCost = new NumberField("max Cost");

    private Button addSolution = new Button("add to Issue List");
    private Button cancel = new Button("cancel");

    private Binder<SolutionDTOImpl> binder = new Binder(SolutionDTOImpl.class);

    public addSolutionView(ManageSolutionControl solutionControl) {
        addClassName("add-Solution-view");

        add(new H1(""));
        add(createFormLayout());
        add(createButtonLayout());
        addSolution.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());

        addSolution.addClickListener(e -> {
            solutionControl.createSolution(binder.getBean());
            Notification.show("successfully added to Improvement Backlog");
            clearForm();
        });

    }

    // Zeugs das in der View benutzt wird

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

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        addSolution.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(addSolution);
        buttonLayout.add(cancel);
        return buttonLayout;
    }*/


}

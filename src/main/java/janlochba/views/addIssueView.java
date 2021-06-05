package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
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
import janlochba.control.ManageIssueControl;
import janlochba.dto.impl.IssueDTOImpl;


@Route(value = "add-Issue", layout = MainView.class)
@PageTitle("add-Issue")
public class addIssueView extends Div {

    // Input Felder

    private TextField id = new TextField("id"); //soll automatisch vergeben werden
    private TextField name = new TextField("Issue name");
    private TextField description = new TextField("Description");
    private ComboBox<String> issueTyp = new ComboBox<>("Issue Typ");
    private NumberField minValue = new NumberField("min Value");
    private NumberField maxValue = new NumberField("max Value");

    // Buttons

    private Button addIssue = new Button("add to Issue List");
    private Button cancel = new Button("cancel");

    private Binder<IssueDTOImpl> binder = new Binder(IssueDTOImpl.class);

    // die View an sich

    public addIssueView(ManageIssueControl issueControl) {
        addClassName("add-Issue-view");
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();
        binder.forField(issueTyp).asRequired("Issue Typ").bind("typ");

        addIssue.addClickListener(click -> validateAndSave());

        addIssue.addClickListener(e -> {
            issueControl.createIssue(binder.getBean());
            Notification.show("successfully added to Issue List");
            clearForm();
        });


    }

    private void validateAndSave() {
        if(binder.isValid()){
            binder.getBean();
        }
    }

    private Component createTitle() {
        return new H1("add Issue");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        issueTyp.setItems("Architecture and Code Structure","Analyzability & Evaluability","Technical Infrastructure","Processes and Organization");
        issueTyp.setPlaceholder("please select");
        formLayout.add(id, name, issueTyp, description, minValue, maxValue);
        return formLayout;
    }

    private void clearForm() {
        binder.setBean(new IssueDTOImpl());
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        addIssue.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        binder.addStatusChangeListener(event -> addIssue.setEnabled(binder.isValid()));
        addIssue.setEnabled(false);
        cancel.addClickListener(e -> clearForm());
        buttonLayout.add(addIssue);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

}
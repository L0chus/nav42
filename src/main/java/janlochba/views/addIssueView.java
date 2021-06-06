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

    private final TextField name = new TextField("Issue name");
    private final TextField description = new TextField("Description");
    private final ComboBox<String> issueTyp = new ComboBox<>("Issue Typ");
    private final NumberField minValue = new NumberField("min Value");
    private final NumberField maxValue = new NumberField("max Value");

    private final Button addIssue = new Button("add to Issue List");
    private final Button cancel = new Button("cancel");

    private final Binder<IssueDTOImpl> binder = new Binder(IssueDTOImpl.class);


    public addIssueView(ManageIssueControl issueControl) {
        addClassName("add-Issue-view");
        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        binder.forField(issueTyp).asRequired("Issue Typ").bind("typ");
        binder.forField(name).asRequired("Issue name").bind("name");
        binder.forField(description).asRequired("Description").bind("description");
        binder.forField(minValue).asRequired("min Value").bind("minValue");
        binder.forField(maxValue).asRequired("max Value").bind("maxValue");

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
        description.getStyle().set("maxHeight", "200%");
        description.setPlaceholder("enter description here...");
        formLayout.add(name, issueTyp, description, minValue, maxValue);
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
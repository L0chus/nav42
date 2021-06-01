package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
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

    private TextField id = new TextField("id"); //soll automatisch vergeben werden
    private TextField name = new TextField("Issue name");
    private TextField description = new TextField("Description");
    private TextField issueTyp = new TextField("Issue Typ");
  //  private ComboBox<String> issueTyp; // nachgucken wie man das macht
    private NumberField minValue = new NumberField("min Value");
    private NumberField maxValue = new NumberField("max Value");

    private Button addIssue = new Button("add to Issue List");
    private Button cancel = new Button("cancel");

    private Binder<IssueDTOImpl> binder = new Binder(IssueDTOImpl.class);

    public addIssueView(ManageIssueControl issueControl) {
        addClassName("add-Issue-view");

        add(createTitle());
        add(createFormLayout());
        add(createButtonLayout());

        binder.bindInstanceFields(this);
        clearForm();

        cancel.addClickListener(e -> clearForm());

        addIssue.addClickListener(e -> {
            issueControl.createIssue(binder.getBean());
            Notification.show("successfully added to Issue List");
        });


    }

    private Component createTitle() {
        return new H3("add Issue");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(id, name,issueTyp, description,  minValue,  maxValue);
        return formLayout;
    }

    private void clearForm() {
        binder.setBean(new IssueDTOImpl());
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        addIssue.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(addIssue);
        buttonLayout.add(cancel);
        return buttonLayout;
    }

}

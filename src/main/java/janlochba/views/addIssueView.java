package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.dto.impl.IssueDTOImpl;
import com.vaadin.flow.data.binder.Binder;


@Route(value = "addIssue", layout = MainView.class)
@PageTitle("add-Issue")
public class addIssueView {

    private TextField id = new TextField("id"); //soll automatisch vergeben werden
    private TextField name = new TextField("Issue name");
    private TextField description = new TextField("Description");
    private ComboBox<String> issueTyp; // nachgucken wie man das macht
    private NumberField minValue = new NumberField("min Value");
    private NumberField maxValue = new NumberField("max Value");

    private Button addIssue = new Button("add to Issue List");
    private Button cancel = new Button("cancel");

    private Binder<IssueDTOImpl> binder = new Binder(IssueDTOImpl.class);

    public addIssueView() {

    }

    private Component createTitle() {
        return new H3("add Issue");
    }

    private Component createFormLayout() {
        FormLayout formLayout = new FormLayout();
        formLayout.add(name, description, issueTyp, minValue,  maxValue);
        return formLayout;
    }
    private void clearForm() {
        binder.setBean(new IssueDTOImpl());
    }

}

package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageIssueControl;
import janlochba.control.ManageSolutionControl;
import janlochba.dto.IssueDTO;
import janlochba.dto.impl.SolutionDTOImpl;
import org.vaadin.gatanaso.MultiselectComboBox;

import java.util.stream.Collectors;

@Route(value = "add-Solution", layout = MainView.class)
@PageTitle("add-Solution")
public class addSolutionView extends Div {


    private final TextField name = new TextField("Solution");
    private final TextField description = new TextField("Description");
    private final NumberField minCost = new NumberField("min Cost");
    private final NumberField maxCost = new NumberField("max Cost");
    private final MultiselectComboBox<IssueDTO> issueListMultiselectComboBox = new MultiselectComboBox<>();


    private final Button tip = new Button("Show Tip");

    private final Button save = new Button("add Solution");
    private final Button cancel = new Button("cancel");

    private final ManageIssueControl issue;

    private final Binder<SolutionDTOImpl> binder = new Binder<>(SolutionDTOImpl.class);

    public addSolutionView(ManageSolutionControl control, ManageIssueControl issue) {
        this.issue = issue;
        addClassName("add-Solution-view");

        add(
                new H1("add Solution"),
                formLayout(),
                new Hr(),
                buttonLayout()
        );

        binder.bindInstanceFields(this);
        clearForm();

        binder.forField(name).asRequired().bind("name");
        binder.forField(description).asRequired().bind("description");
        binder.forField(minCost).asRequired().bind("minCost");
        binder.forField(maxCost).asRequired().bind("maxCost");

        save.addClickListener(event -> {
            SolutionDTOImpl solutionDTO = binder.getBean();
            solutionDTO.setIssues(issueListMultiselectComboBox.getValue().stream().collect(Collectors.toList()));
            control.createSolution(solutionDTO);
            Notification.show("successfully added Solution: " + name.getValue() + " to Improvement Backlog");
            clearForm();
            UI.getCurrent().navigate("Improvement_Backlog");
        });
    }

    private Component formLayout() {
        FormLayout formLayout = new FormLayout();

        name.setPlaceholder("name your Solution");
        description.setPlaceholder("enter your Solution description");
        minCost.setPlaceholder("estimate the minimal cost of your Issue");
        maxCost.setPlaceholder("estimate the maximum cost of your Issue");

        // Befüllen der MultiComboBox mit Issues
        issueListMultiselectComboBox.setPlaceholder("select an Issue");
        issueListMultiselectComboBox.setItemLabelGenerator(IssueDTO::getName);
        issueListMultiselectComboBox.setItems(issue.readAllIssues());

        formLayout.add(
                name,
                description,
                minCost,
                maxCost,
                issueListMultiselectComboBox
        );

        return formLayout;
    }

    private void clearForm() {
        binder.setBean(new SolutionDTOImpl());
    }

    private Component buttonLayout() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        tip.addClickListener(event -> {
            Notification.show("Finding out the cost of an issue usually requires estimation or guessing, so there are uncertainty and probability involved. For example, if a server needs to be rebooted once every 24hrs and an operator needs 30 minutes to perform this reboot (and corresponding activities), then you can approximate the cost of this problem for, let’s say, a month: 5 workdays × 4 weeks × 30 min = 10hrs of operator’s effort.");
        });

        horizontalLayout.add(
                save,
                cancel,
                tip
        );
        save.setThemeName("primary");
        return horizontalLayout;
    }


}

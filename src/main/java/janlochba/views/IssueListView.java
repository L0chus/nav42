package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageIssueControl;
import janlochba.dto.IssueDTO;

import java.util.List;

@Route(value = "Issue_List", layout = MainView.class)
@PageTitle("Issue List")
public class IssueListView extends Div {

    private final List<IssueDTO> issueList;
    private Button addIssue = new Button("add new Issue");

    public IssueListView(ManageIssueControl issueControl) {
        addClassName("issue-list-view");

        issueList = issueControl.readAllIssues();

        add(this.createTitle());

        add(this.createGridTable());

        add(createButtonLayout());

        add(addIssue);

        addIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));

    }

    private Component createGridTable() {
        Grid<IssueDTO> grid = new Grid<>();

        ListDataProvider<IssueDTO> dataProvider = new ListDataProvider<>(issueList);

        grid.setDataProvider(dataProvider);

        Grid.Column<IssueDTO> idColumn = grid.addColumn(IssueDTO::getId).setHeader("ID");
        Grid.Column<IssueDTO> nameColumn = grid.addColumn(IssueDTO::getName).setHeader("Issue");
        Grid.Column<IssueDTO> descriptionColumn = grid.addColumn(IssueDTO::getDescription).setHeader("Description");
        Grid.Column<IssueDTO> typColumn = grid.addColumn(IssueDTO::getTyp).setHeader("Issue Typ");
        Grid.Column<IssueDTO> minValueColumn = grid.addColumn(IssueDTO::getMinValue).setHeader("min Value in €");
        Grid.Column<IssueDTO> maxValueColumn = grid.addColumn(IssueDTO::getMaxValue).setHeader("max Value in €");

        return grid;
    }

    private Component createTitle() {
        return new H3("Issue List");
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        addIssue.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(addIssue);
        return buttonLayout;
    }

}
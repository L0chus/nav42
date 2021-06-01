package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageIssueControl;
import janlochba.dto.IssueDTO;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Issue List", layout = MainView.class)
@PageTitle("Issue List")
public class IssueListView extends Div {

    private final List<IssueDTO> issueList = new ArrayList<>();

    public IssueListView( ManageIssueControl issueControl ) {
        addClassName("issue-list-view");

        //issueList = issueControl.readAllIssues();

        add(this.createTitle());

        add(this.createGridTable());

        Button addIssue = new Button("add new Issue");
        add(addIssue);

    }

    private Component createGridTable(){
        Grid<IssueDTO> grid = new Grid<>();

        ListDataProvider<IssueDTO> dataProvider = new ListDataProvider<>(issueList);

        grid.setDataProvider(dataProvider);

        Grid.Column<IssueDTO> idColumn = grid.addColumn(IssueDTO::getID).setHeader("ID");
        Grid.Column<IssueDTO> nameColumn = grid.addColumn(IssueDTO::getName).setHeader("Issue");
        Grid.Column<IssueDTO> descriptionColumn = grid.addColumn(IssueDTO::getDescription).setHeader("Description");
        Grid.Column<IssueDTO> typColumn = grid.addColumn(IssueDTO::getTyp).setHeader("Issue Typ");
        Grid.Column<IssueDTO> minValueColumn = grid.addColumn(IssueDTO::getMinValue).setHeader("min Value");
        Grid.Column<IssueDTO> maxValueColumn = grid.addColumn(IssueDTO::getMaxValue).setHeader("max Value");

        return grid;
    }

    private Component createTitle() {
        return new H3("Issue List");
    }

}
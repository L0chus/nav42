package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.dto.IssueDTO;

import java.util.ArrayList;
import java.util.List;

@Route(value = "IssueList", layout = MainView.class)
@PageTitle("Issue List")
public class IssueListView extends Div {

    private List<IssueDTO> issueList = new ArrayList<>();
    private Button addIssue = new Button("add new Issue");

    public IssueListView() {
        addClassName("issue-list-view");
        add(createTitle());
        add(this.createGridTable());
        add(this.addIssue);


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

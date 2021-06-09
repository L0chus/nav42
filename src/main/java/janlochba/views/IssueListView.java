package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
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
    private final Button addIssue = new Button("add new Issue");
    private final Button toAnalysis = new Button("go to Analysis");
    private final Grid<IssueDTO> grid = new Grid<>();

    public IssueListView(ManageIssueControl issueControl) {
        addClassName("issue-list-view");

        issueList = issueControl.readAllIssues();

        add(
                new H3("Issue List"),
                createGridTable(),
                createButtonLayout()
        );
    }

    private Component createGridTable() {


        ListDataProvider<IssueDTO> dataProvider = new ListDataProvider<>(issueList);

        grid.setDataProvider(dataProvider);

        Grid.Column<IssueDTO> idColumn = grid.addColumn(IssueDTO::getId).setHeader("ID").setKey("id");
        Grid.Column<IssueDTO> nameColumn = grid.addColumn(IssueDTO::getName).setHeader("Issue").setKey("name");
        Grid.Column<IssueDTO> descriptionColumn = grid.addColumn(IssueDTO::getDescription).setHeader("Description").setKey("description");
        Grid.Column<IssueDTO> typColumn = grid.addColumn(IssueDTO::getTyp).setHeader("Issue Typ").setKey("typ");
        Grid.Column<IssueDTO> minValueColumn = grid.addColumn(IssueDTO::getMinValue).setHeader("min Value in €").setKey("minValue");
        Grid.Column<IssueDTO> maxValueColumn = grid.addColumn(IssueDTO::getMaxValue).setHeader("max Value in €").setKey("maxValue");

        grid.setWidth("100%");
        grid.getColumnByKey("id").setFlexGrow(0).setWidth("50px");
        grid.getColumnByKey("name").setFlexGrow(0).setWidth("15%");
        grid.getColumnByKey("description").setFlexGrow(0).setWidth("35%");
        grid.getColumnByKey("typ").setFlexGrow(0).setWidth("25%");
        grid.getColumnByKey("minValue").setFlexGrow(0).setWidth("10%");
        grid.getColumnByKey("maxValue").setFlexGrow(0).setWidth("10%");

        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        return grid;
    }


    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        addIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));


        addIssue.setThemeName("primary");
        toAnalysis.setThemeName("primary");

        buttonLayout.add(
                addIssue, toAnalysis);
        return buttonLayout;
    }

}
package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
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
    private final Button addIssue = new Button("add new Issue", VaadinIcon.FILE_ADD.create());
    private final Button toImprove = new Button("Improve your Issue");
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
        grid.setWidth("100%");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        Grid.Column<IssueDTO> idColumn = grid.addColumn(IssueDTO::getId).setHeader("ID").setKey("id").setWidth("50px");
        Grid.Column<IssueDTO> nameColumn = grid.addColumn(IssueDTO::getName).setHeader("Issue").setKey("name").setWidth("20%");
        Grid.Column<IssueDTO> descriptionColumn = grid.addColumn(IssueDTO::getDescription).setHeader("Description").setKey("description").setWidth("30%");
        Grid.Column<IssueDTO> typColumn = grid.addColumn(IssueDTO::getTyp).setHeader("Issue Typ").setKey("typ").setWidth("25%").setWidth("20%");
        Grid.Column<IssueDTO> minValueColumn = grid.addColumn(IssueDTO::getMinValue).setHeader("min Value in €").setKey("minValue").setWidth("10%");
        Grid.Column<IssueDTO> maxValueColumn = grid.addColumn(IssueDTO::getMaxValue).setHeader("max Value in €").setKey("maxValue").setWidth("10%");

        return grid;
    }


    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        addIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toImprove.addClickListener(event -> UI.getCurrent().navigate("RecImprove"));

        //hier soll der Typ des Issues in RecImprove Combobox übergeben werden
        toImprove.addClickListener(event -> {
            Object typ = grid.getSelectionModel().getSelectedItems();
            Notification.show(typ.toString());
        });

        addIssue.setThemeName("primary");
        toImprove.setThemeName("primary");

        buttonLayout.add(
                addIssue, toImprove);
        return buttonLayout;
    }

}
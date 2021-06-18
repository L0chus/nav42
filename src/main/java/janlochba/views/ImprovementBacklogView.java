package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageSolutionControl;
import janlochba.dto.SolutionDTO;

import java.util.List;

@Route(value = "Improvement_Backlog", layout = MainView.class)
@PageTitle("Improvement Backlog")

public class ImprovementBacklogView extends Div {

    private final List<SolutionDTO> improvementBacklog;
    private final Button addSolution = new Button("add new Solution", VaadinIcon.FILE_ADD.create());
    private final Button toAnalysis = new Button("go to Analysis");
    private final Button delete = new Button("delete", VaadinIcon.TRASH.create());

    private Integer currentID;


    public ImprovementBacklogView(ManageSolutionControl solutionControl) {

        addClassName("improvement-backlog-view");

        improvementBacklog = solutionControl.readAllSolutions();

        add(
                new H3("Improvement Backlog"),
                this.createGridTable(),
                createButtonLayout()

        );

        // delete by ID funktioniert, es muss nur noch der Refresh funktionieren
        delete.addClickListener(event -> {
            solutionControl.delete(currentID);
            UI.getCurrent().navigate("Improvement_Backlog");
        });
    }

    private Component createGridTable() {
        Grid<SolutionDTO> grid = new Grid<>();

        ListDataProvider<SolutionDTO> dataProvider = new ListDataProvider<>(improvementBacklog);
        grid.setDataProvider(dataProvider);

        grid.setWidth("100%");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        Grid.Column<SolutionDTO> idColumn = grid.addColumn(SolutionDTO::getId).setHeader("ID").setKey("id").setWidth("75px");
        Grid.Column<SolutionDTO> nameColumn = grid.addColumn(SolutionDTO::getName).setHeader("Solution").setKey("name").setWidth("10%");
        Grid.Column<SolutionDTO> descriptionColumn = grid.addColumn(SolutionDTO::getDescription).setHeader("Description").setKey("description").setWidth("20%");
        Grid.Column<SolutionDTO> min_costColumn = grid.addColumn(SolutionDTO::getMinCost).setHeader("min Cost in €").setKey("minCost").setWidth("10%");
        Grid.Column<SolutionDTO> max_costColumn = grid.addColumn(SolutionDTO::getMaxCost).setHeader("max Cost in €").setKey("maxCost").setWidth("10%");
        Grid.Column<SolutionDTO> issues = grid.addColumn(SolutionDTO::getIssues).setHeader("related Issue").setKey("issues").setWidth("10%");

        // currentID soll von dem ausgewählten Element der List gesetzt werden
        currentID = 10;

        return grid;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        addSolution.setThemeName("primary");
        toAnalysis.setThemeName("primary");
        delete.setThemeName("primary");

        addSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));


        buttonLayout.add(
                addSolution,
                toAnalysis,
                delete
        );

        return buttonLayout;
    }
}

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
import janlochba.control.ManageSolutionControl;
import janlochba.dto.SolutionDTO;

import java.util.List;

@Route(value = "Improvement_Backlog", layout = MainView.class)
@PageTitle("Improvement Backlog")

public class ImprovementBacklogView extends Div {

    private final List<SolutionDTO> improvementBacklog;
    private final Button addSolution = new Button("add new Solution");
    private final Button toImprove = new Button("Improve your Issue");


    public ImprovementBacklogView(ManageSolutionControl solutionControl) {

        addClassName("improvement-backlog-view");

        improvementBacklog = solutionControl.readAllSolutions();

        add(
                new H3("Improvement Backlog"),
                this.createGridTable(),
                createButtonLayout()

        );

    }

    private Component createGridTable() {
        Grid<SolutionDTO> grid = new Grid<>();

        ListDataProvider<SolutionDTO> dataProvider = new ListDataProvider<>(improvementBacklog);
        grid.setDataProvider(dataProvider);

        Grid.Column<SolutionDTO> idColumn = grid.addColumn(SolutionDTO::getId).setHeader("ID").setKey("id");
        Grid.Column<SolutionDTO> nameColumn = grid.addColumn(SolutionDTO::getName).setHeader("Solution").setKey("name");
        Grid.Column<SolutionDTO> descriptionColumn = grid.addColumn(SolutionDTO::getDescription).setHeader("Description").setKey("description");
        Grid.Column<SolutionDTO> min_costColumn = grid.addColumn(SolutionDTO::getMinCost).setHeader("min Cost in €").setKey("minCost");
        Grid.Column<SolutionDTO> max_costColumn = grid.addColumn(SolutionDTO::getMaxCost).setHeader("max Cost in €").setKey("maxCost");

        grid.setWidth("75%");
        grid.getColumnByKey("id").setFlexGrow(0).setWidth("75px");
        grid.getColumnByKey("name").setFlexGrow(0).setWidth("10%");
        grid.getColumnByKey("description").setFlexGrow(0).setWidth("45%");
        grid.getColumnByKey("minCost").setFlexGrow(0).setWidth("20%");
        grid.getColumnByKey("maxCost").setFlexGrow(0).setWidth("20%");

        return grid;
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");

        addSolution.setThemeName("primary");
        toImprove.setThemeName("primary");

        addSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toImprove.addClickListener(event -> UI.getCurrent().navigate("RecImprove"));


        buttonLayout.add(
                addSolution,
                toImprove
        );


        return buttonLayout;
    }
}

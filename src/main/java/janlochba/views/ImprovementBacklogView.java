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


    public ImprovementBacklogView(ManageSolutionControl solutionControl) {

        addClassName("improvement-backlog-view");

        improvementBacklog = solutionControl.readAllSolutions();

        add(
                new H3("Improvement Backlog"),
                this.createGridTable(),
                createButtonLayout()

        );

        delete.addClickListener(event -> {
            
        });
    }

    private Component createGridTable() {
        Grid<SolutionDTO> grid = new Grid<>();

        ListDataProvider<SolutionDTO> dataProvider = new ListDataProvider<>(improvementBacklog);
        grid.setDataProvider(dataProvider);

        grid.setWidth("75%");
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);

        Grid.Column<SolutionDTO> idColumn = grid.addColumn(SolutionDTO::getId).setHeader("ID").setKey("id").setWidth("75px");
        Grid.Column<SolutionDTO> nameColumn = grid.addColumn(SolutionDTO::getName).setHeader("Solution").setKey("name").setWidth("10%");
        Grid.Column<SolutionDTO> descriptionColumn = grid.addColumn(SolutionDTO::getDescription).setHeader("Description").setKey("description").setWidth("45%");
        Grid.Column<SolutionDTO> min_costColumn = grid.addColumn(SolutionDTO::getMinCost).setHeader("min Cost in €").setKey("minCost").setWidth("20%");
        Grid.Column<SolutionDTO> max_costColumn = grid.addColumn(SolutionDTO::getMaxCost).setHeader("max Cost in €").setKey("maxCost").setWidth("20%");


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

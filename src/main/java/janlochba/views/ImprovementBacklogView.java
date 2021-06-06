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
import janlochba.control.ManageSolutionControl;
import janlochba.dto.SolutionDTO;

import java.util.List;

@Route(value = "Improvement_Backlog", layout = MainView.class)
@PageTitle("Improvement Backlog")

public class ImprovementBacklogView extends Div {

    private final List<SolutionDTO> improvementBacklog;
    private final Button addSolution = new Button("add new Solution");

    public ImprovementBacklogView(ManageSolutionControl solutionControl) {

        addClassName("improvement-backlog-view");

        improvementBacklog = solutionControl.readAllSolutions();

        add(createTitle());

        add(this.createGridTable());

        add(createButtonLayout());

        add(addSolution);

        addSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));

    }

    private Component createGridTable(){
        Grid<SolutionDTO> grid = new Grid<>();

        ListDataProvider<SolutionDTO> dataProvider = new ListDataProvider<>(improvementBacklog);
        grid.setDataProvider(dataProvider);

        Grid.Column<SolutionDTO> idColumn = grid.addColumn(SolutionDTO::getId).setHeader("ID");
        Grid.Column<SolutionDTO> nameColumn = grid.addColumn(SolutionDTO::getName).setHeader("Solution");
        Grid.Column<SolutionDTO> descriptionColumn = grid.addColumn(SolutionDTO::getDescription).setHeader("Description");
        Grid.Column<SolutionDTO> min_costColumn = grid.addColumn(SolutionDTO::getMinCost).setHeader("min Cost");
        Grid.Column<SolutionDTO> max_costColumn = grid.addColumn(SolutionDTO::getMaxCost).setHeader("max Cost");

        return grid;
    }

    private Component createTitle() {
        return new H3("Improvement Backlog");
    }

    private Component createButtonLayout() {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        buttonLayout.addClassName("button-layout");
        addSolution.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonLayout.add(addSolution);
        return buttonLayout;
    }
}

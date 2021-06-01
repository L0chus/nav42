package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.dto.SolutionDTO;

import java.util.ArrayList;
import java.util.List;

@Route(value = "Improvement_Backlog", layout = MainView.class)
@PageTitle("Improvement Backlog")
public class ImprovementBacklogView extends Div {

    private List<SolutionDTO> improvementBacklog = new ArrayList<>();
    private Button addSolution = new Button("add new Solution");

    public ImprovementBacklogView() {
        addClassName("improvement-backlog-view");
        add(createTitle());
        add(this.createGridTable());
        add(this.addSolution);
    }

    private Component createGridTable(){
        Grid<SolutionDTO> grid = new Grid<>();

        ListDataProvider<SolutionDTO> dataProvider = new ListDataProvider<>(improvementBacklog);
        grid.setDataProvider(dataProvider);

        Grid.Column<SolutionDTO> idColumn = grid.addColumn(SolutionDTO::getID).setHeader("ID");
        Grid.Column<SolutionDTO> nameColumn = grid.addColumn(SolutionDTO::getName).setHeader("Solution");
        Grid.Column<SolutionDTO> descriptionColumn = grid.addColumn(SolutionDTO::getDescription).setHeader("Description");
        Grid.Column<SolutionDTO> minCostColumn = grid.addColumn(SolutionDTO::getMinCost).setHeader("min Cost");
        Grid.Column<SolutionDTO> maxCostColumn = grid.addColumn(SolutionDTO::getMaxCost).setHeader("max Cost");

        return grid;
    }

    private Component createTitle() {
        return new H3("Improvement Backlog");
    }
}

package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.ListDataProvider;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.dto.RecAnalysisDTO;
import janlochba.recommender.RecommendationAnalysis;

import java.util.*;


@Route(value = "RecAnalysis", layout = MainView.class)
@PageTitle("Analysis")
public class RecAnalysisView extends VerticalLayout {

    private String input;
    private String input2;
    private final RecommendationAnalysis analysisControl;
    private final Button toAddIssue = new Button("add new Issue");
    private final List<RecAnalysisDTO> analysisList = new ArrayList<>();
    private final ListDataProvider<RecAnalysisDTO> dataProvider = new ListDataProvider<>(analysisList);


    public RecAnalysisView(RecommendationAnalysis analysisControl) {
        this.analysisControl = analysisControl;

        toAddIssue.setThemeName("primary");
        toAddIssue.setEnabled(false);

        toAddIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        add(
                new H1("Analyze to find new Issues"),
                buildForm(),
                createGridTable(),
                toAddIssue
        );
    }

    private Component createGridTable() {
        Grid<RecAnalysisDTO> analysisGrid = new Grid<>();

        analysisGrid.setDataProvider(dataProvider);
        analysisGrid.addColumn(RecAnalysisDTO::getName).setHeader("Analysis Method:").setKey("name").setWidth("25%");
        analysisGrid.addColumn(RecAnalysisDTO::getDescription).setHeader("More Information under:").setKey("description").setWidth("75%");

        analysisGrid.setWidth("75%");

        return analysisGrid;
    }

    private Component buildForm() {
        // new API
        Map<String, List<String>> lookingAt = new HashMap<>();
        lookingAt.put("new API", List.of("in development", "requirements", "data",
                "Infrastructure", "known error", "general", "not sure", "old issues"));
        // new Project
        lookingAt.put("new Project", List.of("in development", "requirements", "data",
                "Infrastructure", "known error", "general", "not sure", "old issues", "stakeholder"));
        // operated System
        lookingAt.put("operated System", List.of("UI", "API", "Datasource", "data", "known error", "production hardware",
                "Infrastructure", "runtime behavior", "Code Quality", "general", "not sure"));

        //ComboBox 1
        ComboBox<String> box1 = new ComboBox<>("looking at", lookingAt.keySet());
        box1.setPlaceholder("please select");
        box1.setWidth("20%");

        //ComboBox 2
        ComboBox<String> box2 = new ComboBox<>("especially on", Collections.emptyList());
        box2.setPlaceholder("please select");
        box2.setWidth("20%");

        Button recAnalysis = new Button("get a Method");
        Div errorsLayout = new Div();

        recAnalysis.setThemeName("primary");
        recAnalysis.setEnabled(false);
        box2.setEnabled(false);


        box1.addValueChangeListener(e -> {
            String type = e.getValue(); // ??bergibt den String f??r die Methodenausgabe
            input = e.getValue();
            boolean enabled = type != null && !type.isEmpty(); // ??berpr??fen ob die Eingabe leer ist
            box2.setEnabled(enabled);
            if (enabled) {
                box2.setValue(""); // n??chste Combobox auf default setzen
                box2.setItems(lookingAt.get(type)); // die werte von der Liste in Looking at ??bergeben
            }
        });

        box2.addValueChangeListener(e -> {
            String typBox2 = e.getValue();
            input2 = e.getValue();
            boolean enableBox2 = typBox2 != null && !typBox2.isEmpty();
            recAnalysis.setEnabled(enableBox2);
        });

        HorizontalLayout formLayout = new HorizontalLayout(box1, box2, recAnalysis);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        // Empfehlung der Analyse Methode durch DB Abruf mit den 2 Parametern
        recAnalysis.addClickListener(event -> {
            analysisList.clear();
            analysisList.addAll(analysisControl.recAnalysis(input, input2));

            toAddIssue.setEnabled(true);
            dataProvider.refreshAll();
        });

        return wrapperLayout;
    }
}
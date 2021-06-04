package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Route(value = "RecAnalysis", layout = MainView.class)
@PageTitle("Analysis")
public class RecAnalysisView extends VerticalLayout {

    private Button analysis = new Button("analyze");
    private ComboBox<String> box1 = new ComboBox<>();
    private ComboBox<String> box2 = new ComboBox<>();

    public RecAnalysisView() {

        add(
                new H1("Analyze to find new Issues"),
                buildForm()
                // eventuell Tabelle wie in RecImprove
        );

    }

    private Component buildForm() {

        Map<String, List<String>> lookingAt = new HashMap<>();
        lookingAt.put("new Project / new API", Arrays.asList("in development", "requirements", "data", "Infrastructure", "known error", "general", "not sure"));
        lookingAt.put("operated System", Arrays.asList("UI", "API", "Datasource", "Data", "known error", "production hardware", "Infrastructure", "runtime behavior", "Code Quality", "general", "not sure"));

        ComboBox<String> box1 = new ComboBox<>("looking at", lookingAt.keySet());
        ComboBox<String> box2 = new ComboBox<>("especially on", lookingAt.keySet());


        Button recAnalysis = new Button("recommend Method");
        Div errorsLayout = new Div();

        analysis.setThemeName("primary");

        box2.setEnabled(false);
        box1.addValueChangeListener(e -> {
            String typ = e.getValue();
            boolean enabled = typ != null && !typ.isEmpty();
            box2.setEnabled(enabled);
            if (enabled) {
                box2.setValue("");
                box2.setItems(box1.getValue());
            }
        });

        HorizontalLayout formLayout = new HorizontalLayout(box1, box2, analysis);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }
}
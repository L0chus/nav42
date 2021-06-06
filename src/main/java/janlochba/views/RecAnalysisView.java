package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import java.util.*;


@Route(value = "RecAnalysis", layout = MainView.class)
@PageTitle("Analysis")
public class RecAnalysisView extends VerticalLayout {

    public RecAnalysisView() {

        add( new H1("Analyze to find new Issues"), buildForm());

    }

    private Component buildForm() {

        Map<String, List<String>> lookingAt = new HashMap<>();
        lookingAt.put("new API", List.of("in development", "requirements", "data", "Infrastructure", "known error", "general", "not sure"));
        lookingAt.put("new Project", List.of("in development", "requirements", "data", "Infrastructure", "known error", "general", "not sure"));
        lookingAt.put("operated System", List.of("UI", "API", "Datasource", "Data", "known error", "production hardware", "Infrastructure", "runtime behavior", "Code Quality", "general", "not sure"));

        ComboBox<String> box1 = new ComboBox<>("looking at", lookingAt.keySet());
        box1.setPlaceholder("please select");

        ComboBox<String> box2 = new ComboBox<>("especially on", Collections.emptyList());
        box2.setPlaceholder("please select");

        Button recAnalysis = new Button("get a Method");
        Div errorsLayout = new Div();

        recAnalysis.setThemeName("primary");
        recAnalysis.setEnabled(false);

        box2.setEnabled(false);
        box1.addValueChangeListener(e -> {
            String type = e.getValue();
            boolean enabled = type != null && !type.isEmpty();
            box2.setEnabled(enabled);
            if (enabled) {
                box2.setValue("");
                box2.setItems(lookingAt.get(type));
            }
        });
        box2.addValueChangeListener(e -> {
           String typBox2 = e.getValue();
           boolean enableBox2 = typBox2 != null && !typBox2.isEmpty();
           recAnalysis.setEnabled(enableBox2);
        });

        HorizontalLayout formLayout = new HorizontalLayout(box1, box2, recAnalysis);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        recAnalysis.addClickListener(event -> {
            Notification.show(box1.getValue() + " " + box2.getValue());
        });

        return wrapperLayout;
    }
}
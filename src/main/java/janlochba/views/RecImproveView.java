package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.dto.RecImproveDTO;

import java.util.*;

@Route(value = "RecImprove", layout = MainView.class)
@PageTitle("Improve")
public class RecImproveView extends VerticalLayout {

    private Grid<RecImproveDTO> recGrid = new Grid<>(RecImproveDTO.class);

    public RecImproveView(){

        add(
                new H1("Improvement Method for your Issue"),
                buildForm(),
                new H3(" we recommend you the following Method: ")
                );
    }

    private Component buildForm() {
        // Auswahl an Fehlertypen und deren Unterkategorien (2. Box)
        Map<String, List<String>> typOfIssue = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList(""));
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Testing","Simplify Code","Break Dependencies","reporting"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("change"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Documentation"));

        // Auswahl für dritte Box
        Map<String, List<String>> comBox3 = new HashMap<>();
        comBox3.put("Testing", Arrays.asList("preconditions","Units","load","acceptance"));
        comBox3.put("Simplify Code", Arrays.asList("refactoring","reduce Unmaintainable Code","downsize"));
        comBox3.put("Break Dependencies", Arrays.asList("protect other parts from changes","split up Interfaces","Customize interfaces"));
        comBox3.put("reporting", Arrays.asList("-"));
        comBox3.put("change", Arrays.asList("hardware","software"));
        comBox3.put("Documentation", Arrays.asList("improve","expand"));

        ComboBox<String> typSelect = new ComboBox<>("Issue Typ", typOfIssue.keySet());
        ComboBox<String> boxSelect = new ComboBox<>("box1", Collections.emptyList());
        ComboBox<String> box2Select = new ComboBox<>("box2", Collections.emptyList());

        Button recImp = new Button("recommend Method");
        Div errorsLayout = new Div();

        recImp.setThemeName("primary");
        recImp.setEnabled(false);

        boxSelect.setEnabled(false); // box ist gesperrt
        box2Select.setEnabled(false); // box2 ist gesperrt
        typSelect.addValueChangeListener(e -> {
           String typ = e.getValue();
           boolean enabled = typ != null && !typ.isEmpty();
           boxSelect.setEnabled(enabled); // box wird entsperrt
           if(enabled){
               boxSelect.setValue(""); // damit wenn es frei wird auf default ist
               boxSelect.setItems(typOfIssue.get(typ));
           }
        });

        boxSelect.addValueChangeListener(e -> {
            String typ2 = e.getValue();
            boolean enabled = typ2 != null && !typ2.isEmpty();
            box2Select.setEnabled(enabled); // box wird entsperrt
            if(enabled){
                box2Select.setValue(""); // damit wenn es frei wird auf default ist
                box2Select.setItems(comBox3.get(typ2));
            }
        });

        box2Select.addValueChangeListener(e -> {
           String typ3 = e.getValue();
           boolean enableButton = typ3 != null && !typ3.isEmpty();
           recImp.setEnabled(enableButton);
        });

        HorizontalLayout formLayout = new HorizontalLayout(typSelect, boxSelect, box2Select, recImp);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

}

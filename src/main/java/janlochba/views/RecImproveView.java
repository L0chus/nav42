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
                new H3(" we recommend you the following Method: "),
                recGrid);

    }

    private Component buildForm() {
        // Auswahl an Fehlertypen
        Map<String, List<String>> typOfIssue = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList(""));
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Testing","Simplify Code","Break Dependencies","reporting"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("change"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Documentation"));

        // Auswahl für Architecture and Code Structure
        Map<String, List<String>> architectureAndCode = new HashMap<>();
        architectureAndCode.put("Testing", Arrays.asList("preconditions","Units","load","acceptance"));
        architectureAndCode.put("Simplify Code", Arrays.asList("refactoring","reduce Unmaintainable Code","downsize"));
        architectureAndCode.put("Break Dependencies", Arrays.asList("protect other parts from changes","split up Interfaces","Customize interfaces"));
        architectureAndCode.put("reporting", Arrays.asList("-"));
        architectureAndCode.put("change", Arrays.asList("hardware","software"));
        architectureAndCode.put("Documentation", Arrays.asList("improve","expand"));



        ComboBox<String> typSelect = new ComboBox<>("Issue Typ", typOfIssue.keySet());
        ComboBox<String> boxSelect = new ComboBox<>("box1", Collections.emptyList());
        ComboBox<String> box2Select = new ComboBox<>("box2", Collections.emptyList());

        Button recImp = new Button("recommend Method");
        Div errorsLayout = new Div();

        recImp.setThemeName("primary");

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
                box2Select.setItems(architectureAndCode.get(typ2));
            }
        });


        HorizontalLayout formLayout = new HorizontalLayout(typSelect, boxSelect, box2Select, recImp);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

}

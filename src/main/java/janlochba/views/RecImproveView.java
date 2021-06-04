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

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route(value = "RecImprove", layout = MainView.class)
@PageTitle("Improve")
public class RecImproveView extends VerticalLayout {

    private Grid<RecImproveDTO> recGrid = new Grid<>(RecImproveDTO.class);

    private Button analysis = new Button("Improve");

    public RecImproveView(){

        add(
                new H1("Improvement Method for your Issue"),
                buildForm(),
                new H3(" we recommend you the following Method: "),
                recGrid);

    }

    private Component buildForm() {

        Map<String, List<String>> typOfIssue = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList("Test","1","2","3")); // da müssen die einzelnen unterpunkte von Processes and Organization rein
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Test1","1","2","3"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("Test2","1","2","3"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Test3","1","2","3"));

        Map<String, List<String>> typOfBox = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList("Test","1","2","3"));
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Test1","1"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("Test2","2"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Test3","3"));

        Map<String, List<String>> typOfBox2 = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList("Test","1"));
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Test1","1"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("Test2","1"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Test3","66"));

        ComboBox<String> typSelect = new ComboBox<>("Issue Typ", typOfIssue.keySet());
        ComboBox<String> boxSelect = new ComboBox<>("box1", typOfBox.keySet());
        ComboBox<String> box2Select = new ComboBox<>("box2", typOfBox2.keySet());

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
                box2Select.setItems(boxSelect.getValue());
            }
        });


        HorizontalLayout formLayout = new HorizontalLayout(typSelect, boxSelect, box2Select, recImp);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

}

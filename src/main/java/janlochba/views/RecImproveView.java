package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
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

    private Button analysis = new Button("Improve");

    public RecImproveView(){

        add(new H1("get an Improvement Method for your Issue"),
                buildForm(),
                recGrid);

    }

    private Component buildForm() {

        Map<String, List<String>> typOfIssue = new HashMap<>();
        typOfIssue.put("Processes and Organization", Arrays.asList("Test","1","2","3"));
        typOfIssue.put("Architecture and Code Structure", Arrays.asList("Test1","1","2","3"));
        typOfIssue.put("Technical Infrastructure", Arrays.asList("Test2","1","2","3"));
        typOfIssue.put("Analyzability and Evaluatability", Arrays.asList("Test3","1","2","3"));

        ComboBox<String> typSelect = new ComboBox<>("Issue Typ", typOfIssue.keySet());
        ComboBox<String> boxSelect = new ComboBox<>("box1", Collections.emptyList());
        ComboBox<String> box2Select = new ComboBox<>("box2", Collections.emptyList());

        Button recImp = new Button("recommend Method");
        Div errorsLayout = new Div();

        recImp.setThemeName("primary");

        boxSelect.setEnabled(false);
        typSelect.addValueChangeListener(e -> {
           String typ = e.getValue();
           boolean enabled = typ != null && !typ.isEmpty();
           boxSelect.setEnabled(enabled);
           if(enabled){
               boxSelect.setItems(typOfIssue.get(typ));
           }
        });
        box2Select.setEnabled(false);

        HorizontalLayout formlayout = new HorizontalLayout(typSelect, boxSelect, box2Select, recImp);
        Div wrapperLayout = new Div(formlayout, errorsLayout);
        formlayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("200%");


        return wrapperLayout;
    }

}

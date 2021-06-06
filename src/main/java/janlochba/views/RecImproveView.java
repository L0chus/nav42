package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import janlochba.control.ManageRecImproveControl;
import janlochba.dto.RecImproveDTO;

import java.awt.*;
import java.util.*;
import java.util.List;

@Route(value = "RecImprove", layout = MainView.class)
@PageTitle("Improve")
public class RecImproveView extends VerticalLayout {

    private final Grid<RecImproveDTO> recGrid = new Grid<>(RecImproveDTO.class);

    private String input1;
    private String input2;
    private String input3;


    public RecImproveView(){

        add(
                new H1("Improvement Method for your Issue"),
                buildForm(),
                new H3(" we recommend you the following Method: ")
                );
    }

    private Component buildForm() { //ManageRecImproveControl improveControl



        Map<String, List<String>> typOfIssue = new HashMap<>();
        typOfIssue.put("Processes and Organization", List.of(""));
        typOfIssue.put("Architecture and Code Structure", List.of("Testing","Simplify Code","Break Dependencies","reporting"));
        typOfIssue.put("Technical Infrastructure", List.of("change"));
        typOfIssue.put("Analyzability and Evaluatability", List.of("Documentation"));

        Map<String, List<String>> comBox3 = new HashMap<>();
        comBox3.put("Testing", List.of("preconditions","Units","load","acceptance"));
        comBox3.put("Simplify Code", List.of("refactoring","reduce Unmaintainable Code","downsize"));
        comBox3.put("Break Dependencies", List.of("protect other parts from changes","split up Interfaces","Customize interfaces"));
        comBox3.put("reporting", List.of("-"));
        comBox3.put("change", List.of("hardware","software"));
        comBox3.put("Documentation", List.of("improve","expand"));

        ComboBox<String> typSelect = new ComboBox<>("Issue Typ", typOfIssue.keySet());
        ComboBox<String> boxSelect = new ComboBox<>("box1", Collections.emptyList());
        ComboBox<String> box2Select = new ComboBox<>("box2", Collections.emptyList());

        Button recImp = new Button("recommend Method");
        Div errorsLayout = new Div();

        recImp.setThemeName("primary");
        recImp.setEnabled(false);

        boxSelect.setEnabled(false);
        box2Select.setEnabled(false);
        typSelect.addValueChangeListener(e -> {
           String typ = e.getValue();
           input1 = e.getValue(); // Übergibt den String für die Methoden ausgabe
           boolean enabled = typ != null && !typ.isEmpty();
           boxSelect.setEnabled(enabled);
           if(enabled){
               boxSelect.setValue("");
               boxSelect.setItems(typOfIssue.get(typ));
           }
        });

        boxSelect.addValueChangeListener(e -> {
            String typ2 = e.getValue();
            input2 = e.getValue();
            boolean enabled = typ2 != null && !typ2.isEmpty();
            box2Select.setEnabled(enabled);
            if(enabled){
                box2Select.setValue("");
                box2Select.setItems(comBox3.get(typ2));
            }
        });

        box2Select.addValueChangeListener(e -> {
           String typ3 = e.getValue();
           input3 = e.getValue();
           boolean enableButton = typ3 != null && !typ3.isEmpty();
           recImp.setEnabled(enableButton);
           recImp.addClickListener(event -> {

           });

        });
        recImp.addClickListener(event -> {
            Notification.show(input1);
            Notification.show(input2);
            Notification.show(input3);
        });

        //List<RecImproveDTO> recImproveMethod = improveControl.recImprovement(input1,input2,input3);



        HorizontalLayout formLayout = new HorizontalLayout(typSelect, boxSelect, box2Select, recImp);
        Div wrapperLayout = new Div(formLayout, errorsLayout);
        formLayout.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        wrapperLayout.setWidth("100%");

        return wrapperLayout;
    }

}

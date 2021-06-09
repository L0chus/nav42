package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends Div {

    Button toAddIssue = new Button("add new Issue");
    Button toAddSolution = new Button("add new Solution");
    Button toAnalysis = new Button("go to Analysis");
    Button toImprove = new Button("Improve your Issue");

    Label test = new Label();

    public HomeView() {

        addClassName("home-view");

        add(
                new H1("welcome to nav42"),
                new H3(""),
                new H3("Step 1:"),
                new H3("Step 2:"),
                new H3("Step 3:"),
                new H3("Step 4:"),
                new H3("Step 5:"),

                bodyLayout(),
                buttonLayout()
        );

    }

    // Text Elemente mit Lable erstellen

    private Component bodyLayout() {
        Div wrapper = new Div();


        return wrapper;
    }

    private Component buttonLayout() {

        Div buttonLayout = new Div();

        toAddIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toAddSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));
        toImprove.addClickListener(event -> UI.getCurrent().navigate("RecImprove"));

        buttonLayout.add(
                toAddIssue,
                toAddSolution,
                toAnalysis,
                toImprove
        );

        return buttonLayout;
    }


}

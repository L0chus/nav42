package janlochba.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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


    public HomeView() {

        addClassName("home-view");

        toAddIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toAddSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));
        toImprove.addClickListener(event -> UI.getCurrent().navigate("RecImprove"));

        toAddIssue.setThemeName("primary");
        toAddSolution.setThemeName("primary");
        toAnalysis.setThemeName("primary");
        toImprove.setThemeName("primary");


        // Komponenten der View
        add(
                new H1("Welcome to nav42!"),
                new Hr(),
                new H3(""),
                new H3("Here you will find a short step-by-step guide on how to use this prototype."),
                bodyLayout(),
                new Hr()
        );

    }


    private Component bodyLayout() {
        HorizontalLayout wrapper = new HorizontalLayout();
        VerticalLayout text = new VerticalLayout();
        VerticalLayout buttons = new VerticalLayout();

        // Text zu ende einfügen
        text.add(
                new H4("Step 1: go \"to analysis\" page and get a method to analyze your system / project" + "\n"),
                new H4("Step 2: after you used the recommended analyze method, use \"add Issue\" add the issues you found to the Issue List" + "\n"),
                new H4("Step 3: " + "\n"),
                new H4("Step 4: add the proposed solution you found using the improved method to the \"improvement backlog\" via \"add solution\"" + "\n"),
                new H4("Step 5: " + "\n")

        );
        // Buttons auf die selbe größe setzen
        buttons.add(
                toAnalysis,
                toAddIssue,
                toImprove,
                toAddSolution
        );

        wrapper.add(text, buttons);
        return wrapper;
    }

    private Component buttonLayout() {

        HorizontalLayout buttonLayout = new HorizontalLayout();

        buttonLayout.add(
                toAddIssue,
                toAddSolution,
                toAnalysis,
                toImprove
        );

        return buttonLayout;
    }


}

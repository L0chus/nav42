package janlochba.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;

@Route(value = "home", layout = MainView.class)
@RouteAlias(value = "", layout = MainView.class)
@PageTitle("Home")
public class HomeView extends HorizontalLayout {

    public HomeView() {

        addClassName("home-view");

        Button toAddIssue = new Button("add new Issue");
        Button toAddSolution = new Button("add new Solution");
        Button toAnalysis = new Button("go to Analysis");
        Button toImprove = new Button("Improve your Issue");

        add(
                toAddIssue,
                toAddSolution,
                toAnalysis,
                toImprove
        );

        toAddIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toAddSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));
        toImprove.addClickListener(event -> UI.getCurrent().navigate("RecImprove"));
    }


}

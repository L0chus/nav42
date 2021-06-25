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

    Button toAnalysis = new Button("go to Analysis");
    Button toIssueList = new Button("Issue List");
    Button toImprovementBacklog = new Button("Improvement Backlog");

    public HomeView() {

        addClassName("home-view");
        add(
                textLayout(),
                bodyLayout(),
                new Hr()
        );
    }

    // Oberer Teil der View
    private VerticalLayout textLayout() {
        VerticalLayout textLayout = new VerticalLayout();
        textLayout.add(
                new H1("Welcome to nav42!"),
                new Hr(),
                new H3("\n" + "Here you will find a short step-by-step guide on how to use this prototype.")
        );
        return textLayout;
    }

    // unterer Teil der View --> Body
    private Component bodyLayout() {

        HorizontalLayout wrapper = new HorizontalLayout();
        VerticalLayout text = new VerticalLayout();
        VerticalLayout buttons = new VerticalLayout();

        text.add(
                new H4("Step 1: start with \"go to analysis\" and get a method to analyze your system or project to find possible Issues"),
                new H4("Step 2: after you used the recommended analyze method, go on to \"Issue List\" and add a new issues you found to the Issue List"),
                new H4("Step 3: while you're on the \"Issue List\", select the \"issue\" you want to improve and click the \"Improve your Issue\" button."),
                new H4("Step 4: add the proposed solution you found using the improved method to the \"improvement backlog\" via \"add solution\"" + "\n"),
                new H4("""
                        Try to implement your proposed solution and eliminate the "issue". If you have succeeded in doing this, start the process again.
                        Try to incorporate this process into your daily business to ensure that your system always maintains or improves its quality.
                        """)
        );

        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));
        toIssueList.addClickListener(event -> UI.getCurrent().navigate("Issue_List"));
        toImprovementBacklog.addClickListener((event -> UI.getCurrent().navigate("Improvement_Backlog")));

        toAnalysis.setThemeName("primary");
        toIssueList.setThemeName("primary");
        toImprovementBacklog.setThemeName("primary");

        toAnalysis.setWidth("200px");
        toIssueList.setWidth("200px");
        toImprovementBacklog.setWidth("200px");

        buttons.add(
                toAnalysis,
                toIssueList,
                toImprovementBacklog
        );

        wrapper.add(text, buttons);
        return wrapper;
    }


}

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
    Button toIssueList = new Button("Issue List");
    Button toImprovementBacklog = new Button("Improvement Backlog");

    public HomeView() {

        addClassName("home-view");

        toAddIssue.addClickListener(e -> UI.getCurrent().navigate("add-Issue"));
        toAddSolution.addClickListener(event -> UI.getCurrent().navigate("add-Solution"));
        toAnalysis.addClickListener(event -> UI.getCurrent().navigate("RecAnalysis"));
        toIssueList.addClickListener(event -> UI.getCurrent().navigate("Issue_List"));
        toImprovementBacklog.addClickListener((event -> UI.getCurrent().navigate("Improvement_Backlog")));

        toAddIssue.setThemeName("primary");
        toAddSolution.setThemeName("primary");
        toAnalysis.setThemeName("primary");
        toIssueList.setThemeName("primary");
        toImprovementBacklog.setThemeName("primary");

        add(
                new H1("Welcome to nav42!"),
                new Hr(),
                new H3("\n" + "Here you will find a short step-by-step guide on how to use this prototype."),
                bodyLayout(),
                new Hr()
        );

    }

    private Component bodyLayout() {
        HorizontalLayout wrapper = new HorizontalLayout();
        VerticalLayout text = new VerticalLayout();
        VerticalLayout buttons = new VerticalLayout();

        text.add(
                new H4("Step 1: start with \"go to analysis\" and get a method to analyze your system or project to find possible Issues" + "\n"),
                new H4("Step 2: after you used the recommended analyze method, go on to \"Issue List\" and add a new issues you found to the Issue List" + "\n"),
                new H4("Step 3: while you're on the \"Issue List\", select the \"issue\" you want to improve and click the \"Improve your Issue\" button." + "\n"),
                new H4("Step 4: add the proposed solution you found using the improved method to the \"improvement backlog\" via \"add solution\"" + "\n"),
                new H4("""
                        Try to implement your proposed solution and eliminate the "issue". If you have succeeded in doing this, start the process again.
                        Try to incorporate this process into your daily business to ensure that your system always maintains or improves its quality.
                        """)

        );

        toAnalysis.setWidth("200px");
        toAddIssue.setWidth("200px");
        toAddSolution.setWidth("200px");
        toIssueList.setWidth("200px");
        toImprovementBacklog.setWidth("200px");

        buttons.add(
                toAnalysis,
                //toAddIssue,
                toIssueList,
                //toAddSolution,
                toImprovementBacklog
        );

        wrapper.add(text, buttons);
        return wrapper;
    }

}

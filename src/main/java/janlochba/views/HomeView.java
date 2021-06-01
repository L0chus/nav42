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
        add(toAddIssue);

        toAddIssue.addClickListener(e -> {
            // navigation mit dem Button geht, der Fehler liegt also in addIssueView ...
            UI.getCurrent().navigate("addIssue");

        });
    }

}

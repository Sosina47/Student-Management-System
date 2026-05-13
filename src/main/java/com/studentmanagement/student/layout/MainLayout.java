package com.studentmanagement.student.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.lumo.Lumo;

public class MainLayout extends AppLayout {

    public MainLayout() {

        H2 logo = new H2("Student System");

        Tab dashboardTab =
                new Tab(
                        new RouterLink(
                                "Dashboard",
                                com.studentmanagement.student.ui.DashboardView.class
                        )
                );

        Tab studentsTab =
                new Tab(
                        new RouterLink(
                                "Students",
                                com.studentmanagement.student.ui.StudentView.class
                        )
                );

        Tab aboutTab =
                new Tab(
                        new RouterLink(
                                "About",
                                com.studentmanagement.student.ui.AboutView.class
                        )
                );

        Button themeToggle = new Button(
                "Toggle Dark Mode",
                new Icon(VaadinIcon.MOON)
        );

        themeToggle.addThemeVariants(
                ButtonVariant.LUMO_CONTRAST
        );

        themeToggle.addClickListener(e -> {

            if (getElement().getThemeList()
                    .contains(Lumo.DARK)) {

                getElement().getThemeList()
                        .remove(Lumo.DARK);

            } else {

                getElement().getThemeList()
                        .add(Lumo.DARK);
            }
        });

        VerticalLayout menu = new VerticalLayout(
                logo,
                dashboardTab,
                studentsTab,
                aboutTab,
                themeToggle
        );

        addToDrawer(menu);
    }
}

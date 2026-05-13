package com.studentmanagement.student.layout;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.studentmanagement.student.ui.components.ThemeToggleButton;

public class MainLayout extends AppLayout {

        public MainLayout() {

                H2 logo = new H2("Student System");

                Tab dashboardTab = new Tab(
                                new RouterLink(
                                                "Dashboard",
                                                com.studentmanagement.student.ui.DashboardView.class));

                Tab studentsTab = new Tab(
                                new RouterLink(
                                                "Students",
                                                com.studentmanagement.student.ui.StudentView.class));

                Tab aboutTab = new Tab(
                                new RouterLink(
                                                "About",
                                                com.studentmanagement.student.ui.AboutView.class));
                
                ThemeToggleButton themeToggle = new ThemeToggleButton("Toggle Dark Mode", VaadinIcon.MOON);

                VerticalLayout menu = new VerticalLayout(
                                logo,
                                dashboardTab,
                                studentsTab,
                                aboutTab,
                                themeToggle);

                addToDrawer(menu);
        }
}

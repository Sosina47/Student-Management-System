package com.studentmanagement.student.ui;

import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard")
public class DashboardView extends VerticalLayout {

    public DashboardView() {

        // Page Title
        H1 title = new H1("Dashboard");

        // -----------------------------
        // Total Students Card
        // -----------------------------

        Div totalStudentsCard = createCard(
                "Total Students",
                "25"
        );

        // -----------------------------
        // Departments Card
        // -----------------------------

        Div departmentsCard = createCard(
                "Departments",
                "3"
        );

        // -----------------------------
        // System Status Card
        // -----------------------------

        Div systemStatusCard = createCard(
                "System Status",
                "Running"
        );

        // Dashboard Layout
        HorizontalLayout cardsLayout =
                new HorizontalLayout(
                        totalStudentsCard,
                        departmentsCard,
                        systemStatusCard
                );

        cardsLayout.setSpacing(true);

        add(title, cardsLayout);

        setPadding(true);
        setSpacing(true);
    }

    // Reusable Card Method
    private Div createCard(String title, String value) {

        H3 cardTitle = new H3(title);

        Paragraph cardValue =
                new Paragraph(value);

        cardValue.getStyle()
                .set("font-size", "24px")
                .set("font-weight", "bold");

        Div card = new Div(
                cardTitle,
                cardValue
        );

        card.setWidth("250px");

        card.getStyle()
                .set("padding", "20px")
                .set("border-radius", "15px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "var(--lumo-body-text-color)")
                .set("box-shadow",
                        "0 4px 10px rgba(0,0,0,0.1)")
                .set("border",
                        "1px solid var(--lumo-contrast-10pct)");

        return card;
    }
}
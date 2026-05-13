package com.studentmanagement.student.ui;

import com.studentmanagement.student.ui.components.InfoCard;
import com.studentmanagement.student.ui.components.SectionHeading;
import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "about", layout = MainLayout.class)
@PageTitle("About")
public class AboutView extends VerticalLayout {

    public AboutView() {

        setPadding(true);
        setSpacing(true);

        // Main Title
        H1 mainTitle = new H1("About Vaadin Framework");
        mainTitle.getStyle().set("color", "var(--lumo-primary-text-color)");

        // Introduction
        Paragraph intro = new Paragraph(
                "Vaadin is a powerful Java framework designed to build modern, responsive web applications entirely in Java. "
                        + "It eliminates the need for JavaScript expertise and provides a server-centric development model "
                        + "with automatic client-server synchronization."
        );
        intro.getStyle().set("font-size", "16px").set("line-height", "1.6");

        add(mainTitle, intro);

        add(new SectionHeading("Core Architecture"));

        HorizontalLayout architectureCards = new HorizontalLayout(
                new InfoCard(
                        "Server-Driven Model",
                        "All UI logic and business logic live on the server. "
                                + "Vaadin automatically synchronizes the state between the browser and the server.",
                        VaadinIcon.SERVER
                ),
                new InfoCard(
                        "Automatic Communication",
                        "No need to write REST APIs or handle JSON manually. "
                                + "The framework handles all client-server communication seamlessly.",
                        VaadinIcon.GLOBE
                ),
                new InfoCard(
                        "Secure by Design",
                        "Since UI logic runs on the server, your application is naturally protected "
                                + "against common web vulnerabilities.",
                        VaadinIcon.LOCK
                )
        );
        architectureCards.setSpacing(true);
        architectureCards.setWidthFull();
        add(architectureCards);

        add(new SectionHeading("✨ Key Features"));

        HorizontalLayout featureCards = new HorizontalLayout(
                new InfoCard(
                        "Rich Components",
                        "50+ built-in, accessible, and themeable web components including Grid, Form, Dialog, and more.",
                        VaadinIcon.CUBE
                ),
                new InfoCard(
                        "Data Binding & Validation",
                        "Use Binder to connect Java objects to UI fields with automatic validation and error handling.",
                        VaadinIcon.LINK
                ),
                new InfoCard(
                        "Responsive Routing",
                        "Built-in routing system with @Route annotations for clean, type-safe navigation.",
                        VaadinIcon.ROAD
                )
        );
        featureCards.setSpacing(true);
        featureCards.setWidthFull();
        add(featureCards);

        HorizontalLayout moreFeatureCards = new HorizontalLayout(
                new InfoCard(
                        "Advanced Theming",
                        "Lumo theme system allows full customization of UI appearance using CSS and design tokens.",
                        VaadinIcon.PALETTE
                ),
                new InfoCard(
                        "Type-Safe Components",
                        "All components are Java objects with compile-time safety and IDE support.",
                        VaadinIcon.CODE
                ),
                new InfoCard(
                        "Real-Time Updates",
                        "Server can push updates to the client instantly using WebSockets without page refresh.",
                        VaadinIcon.FLASH
                )
        );
        moreFeatureCards.setSpacing(true);
        moreFeatureCards.setWidthFull();
        add(moreFeatureCards);

        add(new SectionHeading("📚 Technologies Used in This Student Management System"));

        HorizontalLayout projectTechCards = new HorizontalLayout(
                new InfoCard("Spring Boot", "Framework for building production-ready applications with minimal configuration"),
                new InfoCard("Vaadin Flow", "Building the entire UI in 100% Java with server-side logic"),
                new InfoCard("H2 Database", "In-memory database for student data persistence")
        );
        projectTechCards.setSpacing(true);
        projectTechCards.setWidthFull();
        add(projectTechCards);

        HorizontalLayout projectFeatureCards = new HorizontalLayout(
                new InfoCard("Binder & Validation", "Form data binding with automatic validation and error messages"),
                new InfoCard("Components Used", "Grid, Dialog, Button, ComboBox, TextField, Notification"),
                new InfoCard("Routing & Navigation", "@Route annotations for multi-page experience")
        );
        projectFeatureCards.setSpacing(true);
        projectFeatureCards.setWidthFull();
        add(projectFeatureCards);

        add(new SectionHeading("Why Vaadin for This Project"));

        Div whyVaadinCard = new Div();
        whyVaadinCard.getStyle()
                .set("padding", "30px")
                .set("border-radius", "12px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border", "2px solid var(--lumo-primary-color)")
                .set("box-shadow", "0 4px 12px rgba(0,0,0,0.1)");

        H3 whyTitle = new H3("Perfect Fit for Student Management");
        whyTitle.getStyle().set("margin-top", "0");

        UnorderedList whyList = new UnorderedList();
        whyList.add(
                new ListItem("Java developers can build full-stack applications without learning JavaScript"),
                new ListItem("Built-in components like Grid and Dialog make creating CRUD interfaces simple"),
                new ListItem("Form validation with Binder ensures data integrity at the UI level"),
                new ListItem("Responsive layout system adapts to different screen sizes automatically"),
                new ListItem("Theming allows consistent branding across the entire application"),
                new ListItem("Server-centric model keeps business logic secure and maintainable")
        );
        whyList.getStyle().set("font-size", "15px").set("line-height", "1.8");

        whyVaadinCard.add(whyTitle, whyList);
        add(whyVaadinCard);

        add(new SectionHeading("About This Application"));

        Div projectInfoCard = new Div();
        projectInfoCard.getStyle()
                .set("padding", "25px")
                .set("border-radius", "12px")
                .set("background-color", "var(--lumo-shade-10pct)")
                .set("border", "1px solid var(--lumo-contrast-10pct)");

        H3 appTitle = new H3("Student Management System");
        appTitle.getStyle().set("margin-top", "0").set("color", "var(--lumo-primary-text-color)");

        Paragraph projectDesc = new Paragraph(
                "This Student Management System is a demonstration of Vaadin's capabilities. "
                        + "It showcases how to build a complete, responsive web application with features like: "
                        + "user authentication, student CRUD operations, data validation, real-time grid updates, "
                        + "dashboard analytics, and a modern, attractive user interface."
        );
        projectDesc.getStyle().set("font-size", "15px").set("line-height", "1.7");

        Paragraph techStack = new Paragraph();
        techStack.getStyle().set("font-size", "14px").set("color", "var(--lumo-secondary-text-color)");
        techStack.setText("Technology Stack: Java 25, Spring Boot 4.0.6, Vaadin Flow 25.1.5, H2 Database, Maven");

        projectInfoCard.add(appTitle, projectDesc, techStack);
        add(projectInfoCard);

        // ========================================
        // Footer
        // ========================================
        Div footer = new Div();
        footer.getStyle()
                .set("text-align", "center")
                .set("margin-top", "40px")
                .set("padding-top", "20px")
                .set("border-top", "1px solid var(--lumo-contrast-10pct)")
                .set("color", "var(--lumo-secondary-text-color)")
                .set("font-size", "13px");

        Paragraph footerText = new Paragraph("For more information, visit ");
        footerText.getStyle().set("display", "inline");

        footer.add(footerText);
        add(footer);
    }
}
package com.studentmanagement.student.ui;

import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "about", layout = MainLayout.class)
@PageTitle("About")
public class AboutView extends VerticalLayout {

    public AboutView() {

        H1 title = new H1("About Vaadin");

        Paragraph text = new Paragraph(
                "Vaadin is a Java framework used to build modern web applications entirely in Java."
        );

        add(title, text);
    }
}
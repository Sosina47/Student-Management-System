package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.H2;

public class SectionHeading extends H2 {

    public SectionHeading(String title) {
        super(title);

        getStyle()
                .set("margin-top", "40px")
                .set("margin-bottom", "20px")
                .set("color", "var(--lumo-primary-text-color)")
                .set("border-bottom", "3px solid var(--lumo-primary-color)")
                .set("padding-bottom", "10px");
    }
}
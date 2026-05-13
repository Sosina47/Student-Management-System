package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class InfoCard extends Div {

    public InfoCard(String title, String description) {
        this(title, description, null);
    }

    public InfoCard(String title, String description, VaadinIcon icon) {
        setWidthFull();
        getStyle()
                .set("padding", "25px")
                .set("border-radius", "10px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border", "1px solid var(--lumo-contrast-10pct)")
                .set("box-shadow", "0 2px 8px rgba(0,0,0,0.08)")
                .set("transition", "all 0.3s ease")
                .set("cursor", "pointer");

        if (icon != null) {
            Icon cardIcon = new Icon(icon);
            cardIcon.getStyle()
                    .set("width", "40px")
                    .set("height", "40px")
                    .set("color", "var(--lumo-primary-color)")
                    .set("margin-bottom", "10px");
            add(cardIcon);
        }

        H3 cardTitle = new H3(title);
        cardTitle.getStyle()
                .set("margin-top", "0")
                .set("margin-bottom", "10px");

        Paragraph cardDesc = new Paragraph(description);
        cardDesc.getStyle()
                .set("font-size", "14px")
                .set("line-height", "1.6")
                .set("margin", "0");

        add(cardTitle, cardDesc);
    }
}
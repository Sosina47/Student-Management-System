package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

public class IconMetricCard extends Div {

    private final Paragraph valueText;

    public IconMetricCard(String title, String value, VaadinIcon icon) {
        Icon titleIcon = new Icon(icon);
        titleIcon.getStyle()
                .set("color", "var(--lumo-primary-color)")
                .set("margin-right", "8px");

        H3 cardTitle = new H3();
        cardTitle.getStyle().set("margin", "0");
        cardTitle.add(titleIcon);
        cardTitle.add(title);

        valueText = new Paragraph(value);
        valueText.getStyle()
                .set("font-size", "24px")
                .set("font-weight", "bold")
                .set("margin", "8px 0 0 0");

        setWidthFull();
        getStyle()
                .set("padding", "20px")
                .set("border-radius", "15px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "var(--lumo-body-text-color)")
                .set("box-shadow", "0 4px 10px rgba(0,0,0,0.1)")
                .set("border", "1px solid var(--lumo-contrast-10pct)");

        add(cardTitle, valueText);
    }

    public void setValue(String value) {
        valueText.setText(value);
    }
}
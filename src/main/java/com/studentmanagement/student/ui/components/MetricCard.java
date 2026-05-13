package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;

public class MetricCard extends Div {

    private final Paragraph valueText;

    public MetricCard(String title, String value) {
        this(title, value, "250px");
    }

    public MetricCard(String title, String value, String width) {
        H3 cardTitle = new H3(title);
        valueText = new Paragraph(value);

        valueText.getStyle()
                .set("font-size", "24px")
                .set("font-weight", "bold")
                .set("margin", "0");

        setWidth(width);
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
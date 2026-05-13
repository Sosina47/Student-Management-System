package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class SystemStatusCard extends Div {

    public SystemStatusCard(String text) {
        Icon statusIcon = new Icon(VaadinIcon.SHIELD);
        statusIcon.getStyle()
                .set("color", "var(--lumo-primary-color)")
                .set("margin-right", "8px");

        H3 title = new H3();
        title.getStyle().set("margin", "0");
        title.add(statusIcon);
        title.add("System Status");

        HorizontalLayout badgeRow = new HorizontalLayout(new StatusBadge(text));
        badgeRow.setPadding(false);
        badgeRow.setSpacing(false);

        setWidthFull();
        getStyle()
                .set("padding", "20px")
                .set("border-radius", "15px")
                .set("background-color", "var(--lumo-base-color)")
                .set("color", "var(--lumo-body-text-color)")
                .set("box-shadow", "0 4px 10px rgba(0,0,0,0.1)")
                .set("border", "1px solid var(--lumo-contrast-10pct)");

        add(title, badgeRow);
    }
}
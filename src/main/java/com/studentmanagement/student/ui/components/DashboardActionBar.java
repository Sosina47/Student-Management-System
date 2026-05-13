package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class DashboardActionBar extends HorizontalLayout {

    public DashboardActionBar(Runnable onRefresh) {
        Button refreshButton = new Button("Refresh Metrics", new Icon(VaadinIcon.REFRESH));
        refreshButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        refreshButton.addClickListener(event -> {
            onRefresh.run();
            Notification.show("Dashboard refreshed.", 1500, Position.TOP_CENTER);
        });

        Button alertButton = new Button("Test System Alert", new Icon(VaadinIcon.BELL));
        alertButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        alertButton.addClickListener(event ->
                Notification.show("System is running on Pure Java!", 3000, Position.TOP_CENTER)
        );

        setWidthFull();
        setSpacing(true);
        add(refreshButton, alertButton);
    }
}
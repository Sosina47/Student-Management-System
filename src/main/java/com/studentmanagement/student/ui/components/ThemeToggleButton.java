package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.theme.lumo.Lumo;

public class ThemeToggleButton extends Button {

    public ThemeToggleButton(String label, VaadinIcon icon) {
        super(label, new Icon(icon));

        addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        addClickListener(event -> getUI().ifPresent(ui -> {
            if (ui.getElement().getThemeList().contains(Lumo.DARK)) {
                ui.getElement().getThemeList().remove(Lumo.DARK);
            } else {
                ui.getElement().getThemeList().add(Lumo.DARK);
            }
        }));
    }
}
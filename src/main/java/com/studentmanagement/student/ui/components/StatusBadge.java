package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.html.Span;

public class StatusBadge extends Span {

    public StatusBadge(String text) {
        super(text);
        getElement().getThemeList().add("badge success");
    }
}
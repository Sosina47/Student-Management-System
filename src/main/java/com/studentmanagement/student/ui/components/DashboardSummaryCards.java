package com.studentmanagement.student.ui.components;

import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class DashboardSummaryCards extends HorizontalLayout {

    private final IconMetricCard totalStudentsCard;
    private final IconMetricCard departmentsCard;

    public DashboardSummaryCards() {
        totalStudentsCard = new IconMetricCard("Total Students", "0", VaadinIcon.USERS);
        departmentsCard = new IconMetricCard("Departments", "0", VaadinIcon.SITEMAP);

        setWidthFull();
        setSpacing(true);

        add(totalStudentsCard, departmentsCard, new SystemStatusCard("Demo Data Ready"));
        expand(totalStudentsCard, departmentsCard);
    }

    public void setCounts(int totalStudents, int departments) {
        totalStudentsCard.setValue(String.valueOf(totalStudents));
        departmentsCard.setValue(String.valueOf(departments));
    }
}
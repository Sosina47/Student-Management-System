package com.studentmanagement.student.ui;

import com.studentmanagement.student.ui.components.MetricCard;
import com.studentmanagement.student.ui.components.SectionHeading;
import com.studentmanagement.student.service.StudentService;
import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "dashboard", layout = MainLayout.class)
@PageTitle("Dashboard")
public class DashboardView extends VerticalLayout {

    public DashboardView(StudentService studentService) {

        setPadding(true);
        setSpacing(true);

        add(new SectionHeading("Dashboard"));

        int totalStudents = studentService.getTotalStudents();
        int departments = studentService.countDepartments();

        HorizontalLayout cardsLayout = new HorizontalLayout(
                new MetricCard("Total Students", String.valueOf(totalStudents)),
                new MetricCard("Departments", String.valueOf(departments)),
                new MetricCard("System Status", "Demo Data Ready")
        );

        cardsLayout.setSpacing(true);
        cardsLayout.setWidthFull();

        add(cardsLayout);
    }
}
package com.studentmanagement.student.ui;

import com.studentmanagement.student.ui.components.DashboardPanel;
import com.studentmanagement.student.ui.components.SectionHeading;
import com.studentmanagement.student.service.StudentService;
import com.studentmanagement.student.layout.MainLayout;
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
                add(new DashboardPanel(studentService));
        }
}
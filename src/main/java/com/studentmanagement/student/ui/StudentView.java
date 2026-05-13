package com.studentmanagement.student.ui;

import com.studentmanagement.student.service.StudentService;
import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.studentmanagement.student.ui.components.StudentCrudPanel;

@Route(value = "students", layout = MainLayout.class)
public class StudentView extends VerticalLayout {

        public StudentView(StudentService studentService) {
                setPadding(true);
                setSpacing(true);

                add(new StudentCrudPanel(studentService));
        }
}
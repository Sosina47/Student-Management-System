package com.studentmanagement.student.ui.components;

import com.studentmanagement.student.model.Student;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Comparator;
import java.util.List;

public class RecentStudentsGrid extends VerticalLayout {

    private final Grid<Student> grid = new Grid<>(Student.class, false);

    public RecentStudentsGrid() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        getStyle()
                .set("border-radius", "15px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border", "1px solid var(--lumo-contrast-10pct)")
                .set("box-shadow", "0 4px 10px rgba(0,0,0,0.08)");

        grid.addColumn(Student::getId).setHeader("ID").setAutoWidth(true);
        grid.addColumn(Student::getName).setHeader("Name").setAutoWidth(true);
        grid.addColumn(Student::getDepartment).setHeader("Department").setAutoWidth(true);
        grid.addColumn(Student::getYear).setHeader("Year").setAutoWidth(true);

        add(new H3("Last 3 Added Students"), grid);
    }

    public void setStudents(List<Student> students) {
        List<Student> recent = students.stream()
                .sorted(Comparator.comparingInt(Student::getId).reversed())
                .limit(3)
                .toList();

        grid.setItems(recent);
    }
}
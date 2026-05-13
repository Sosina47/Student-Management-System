package com.studentmanagement.student.ui.components;

import com.studentmanagement.student.model.Student;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.progressbar.ProgressBar;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DepartmentDistributionChart extends VerticalLayout {

    public DepartmentDistributionChart() {
        setWidthFull();
        setPadding(true);
        setSpacing(true);

        getStyle()
                .set("border-radius", "15px")
                .set("background-color", "var(--lumo-base-color)")
                .set("border", "1px solid var(--lumo-contrast-10pct)")
                .set("box-shadow", "0 4px 10px rgba(0,0,0,0.08)");

        add(new H3("Students per Department"));
    }

    public void setStudents(List<Student> students) {
        removeAll();
        add(new H3("Students per Department"));

        int total = students.size();
        if (total == 0) {
            add(new Span("No student data available."));
            return;
        }

        Map<String, Long> byDepartment = students.stream()
                .collect(Collectors.groupingBy(Student::getDepartment, Collectors.counting()));

        byDepartment.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> add(createBarRow(entry.getKey(), entry.getValue(), total)));
    }

    private Div createBarRow(String department, long count, int total) {
        double ratio = (double) count / total;
        int percent = (int) Math.round(ratio * 100);

        HorizontalLayout labelRow = new HorizontalLayout();
        labelRow.setWidthFull();
        labelRow.setSpacing(false);
        labelRow.setJustifyContentMode(JustifyContentMode.BETWEEN);

        Span title = new Span(department);
        Span value = new Span(count + " students (" + percent + "%)");
        value.getStyle().set("color", "var(--lumo-secondary-text-color)");

        labelRow.add(title, value);

        ProgressBar bar = new ProgressBar(0, 1, ratio);
        bar.setWidthFull();

        Div row = new Div();
        row.getStyle().set("margin-bottom", "10px");
        row.add(labelRow, bar);
        return row;
    }
}
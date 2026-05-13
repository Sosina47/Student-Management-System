package com.studentmanagement.student.ui.components;

import com.studentmanagement.student.model.Student;
import com.studentmanagement.student.service.StudentService;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.List;

public class DashboardPanel extends VerticalLayout {

    private final StudentService studentService;
    private final DashboardSummaryCards summaryCards;
    private final DepartmentDistributionChart distributionChart;
    private final RecentStudentsGrid recentStudentsGrid;

    public DashboardPanel(StudentService studentService) {
        this.studentService = studentService;

        summaryCards = new DashboardSummaryCards();
        distributionChart = new DepartmentDistributionChart();
        recentStudentsGrid = new RecentStudentsGrid();

        setWidthFull();
        setSpacing(true);
        setPadding(false);

        add(
                new DashboardActionBar(this::refresh),
                summaryCards,
                distributionChart,
                recentStudentsGrid);

        refresh();
    }

    public void refresh() {
        List<Student> students = studentService.getAllStudents();

        summaryCards.setCounts(
                studentService.getTotalStudents(),
                studentService.countDepartments());
        distributionChart.setStudents(students);
        recentStudentsGrid.setStudents(students);
    }
}
package com.studentmanagement.student.ui;

import com.studentmanagement.student.service.StudentService;
import com.studentmanagement.student.layout.MainLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.studentmanagement.student.model.Student;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;

import java.util.ArrayList;
import java.util.List;

@Route(value = "students", layout = MainLayout.class)
public class StudentView extends VerticalLayout {

        private final StudentService studentService;
        private List<Student> students;
        private Student selectedStudent = null;
        private final Binder<Student> binder = new Binder<>(Student.class);

        public StudentView(StudentService studentService) {
                this.studentService = studentService;
                this.students = new ArrayList<>(studentService.getAllStudents());

                // Title
                H1 title = new H1("Student Management System");

                Div totalStudentsCard = new Div();
                totalStudentsCard.setWidth("200px");
                totalStudentsCard.getStyle()
                                .set("padding", "20px")
                                .set("border-radius", "10px")
                                .set("background-color", "var(--lumo-base-color)")
                                .set("color", "var(--lumo-body-text-color)")
                                .set("border",
                                                "1px solid var(--lumo-contrast-10pct)");

                H3 totalStudentsText = new H3("Total Students: 0");
                totalStudentsText.setText("Total Students: " + students.size());

                totalStudentsCard.add(totalStudentsText);

                // Form Fields
                TextField nameField = new TextField("Student Name");

                ComboBox<String> departmentField = new ComboBox<>("Department");
                departmentField.setItems(
                                "Software Engineering",
                                "Computer Science",
                                "Information Systems");

                ComboBox<Integer> yearField = new ComboBox<>("Year");
                yearField.setItems(1, 2, 3, 4, 5);

                TextField sectionField = new TextField("Section");

                nameField.setRequiredIndicatorVisible(true);
                departmentField.setRequiredIndicatorVisible(true);
                yearField.setRequiredIndicatorVisible(true);
                sectionField.setRequiredIndicatorVisible(true);

                binder.forField(nameField)
                                .asRequired("Student name is required")
                                .withValidator(name -> name.trim().length() >= 2,
                                                "Student name must be at least 2 characters")
                                .bind(Student::getName, Student::setName);

                binder.forField(departmentField)
                                .asRequired("Department is required")
                                .bind(Student::getDepartment, Student::setDepartment);

                binder.forField(yearField)
                                .asRequired("Year is required")
                                .bind(Student::getYear, Student::setYear);

                binder.forField(sectionField)
                                .asRequired("Section is required")
                                .withValidator(section -> section.trim().length() >= 1,
                                                "Section is required")
                                .bind(Student::getSection, Student::setSection);

                binder.setBean(new Student());

                // Button
                Button addButton = new Button(
                                "Save Student",
                                new Icon(VaadinIcon.PLUS));

                addButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

                // Grid
                TextField searchField = new TextField();

                searchField.setPlaceholder("Search students...");

                searchField.setWidth("300px");
                Grid<Student> grid = new Grid<>(Student.class, false);

                searchField.addValueChangeListener(e -> {

                        String searchText = e.getValue().toLowerCase();

                        List<Student> filteredStudents = students.stream()
                                        .filter(student ->

                                        student.getName() != null &&
                                                        student.getName().toLowerCase().contains(searchText)

                                        )
                                        .toList();

                        grid.setItems(filteredStudents);
                });

                grid.addColumn(Student::getName)
                                .setHeader("Name");

                grid.addColumn(Student::getDepartment)
                                .setHeader("Department");

                grid.addColumn(Student::getYear)
                                .setHeader("Year");

                grid.addColumn(Student::getSection)
                                .setHeader("Section");

                grid.addComponentColumn(student -> {

                        Button editButton = new Button(
                                        "Edit",
                                        new Icon(VaadinIcon.EDIT));

                        editButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

                        editButton.addClickListener(e -> {
                                selectedStudent = student;
                                binder.setBean(student);
                                Notification.show("Editing student: " + student.getName());
                        });

                        Button deleteButton = new Button(
                                        "Delete",
                                        new Icon(VaadinIcon.TRASH));

                        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);

                        deleteButton.addClickListener(e -> {

                                students.remove(student);

                                refreshGrid(grid, searchField);
                                totalStudentsText.setText("Total Students: " + students.size());

                                Notification.show("Student Deleted!");

                        });

                        return new HorizontalLayout(editButton, deleteButton);

                }).setHeader("Actions");

                // Horizontal Form Layout
                HorizontalLayout formLayout = new HorizontalLayout(
                                nameField,
                                departmentField,
                                yearField,
                                sectionField,
                                addButton);

                // Button Click Event
                addButton.addClickListener(e -> {

                        if (!binder.validate().isOk()) {
                                return;
                        }

                        // EDIT EXISTING STUDENT
                        if (selectedStudent != null) {

                                Notification.show("Student Updated!");

                                selectedStudent = null;

                        } else {

                                // ADD NEW STUDENT
                                students.add(binder.getBean());

                                Notification.show("Student Added!");
                        }

                        // Refresh Grid
                        refreshGrid(grid, searchField);
                        totalStudentsText.setText("Total Students: " + students.size());

                        binder.setBean(new Student());
                });

                // Add Components To Page
                add(title, totalStudentsCard, searchField, formLayout, grid);

                refreshGrid(grid, searchField);

                // Layout Settings
                setSpacing(true);
                setPadding(true);
        }

        private void refreshGrid(Grid<Student> grid, TextField searchField) {

                String searchText = searchField.getValue().toLowerCase();

                List<Student> filteredStudents = students.stream()
                                .filter(student ->

                                student.getName() != null &&
                                                student.getName().toLowerCase().contains(searchText)

                                )
                                .toList();

                grid.setItems(filteredStudents);
        }
}
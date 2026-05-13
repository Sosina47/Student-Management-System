package com.studentmanagement.student.ui;

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
import com.vaadin.flow.router.Route;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.dialog.Dialog;

import java.util.ArrayList;
import java.util.List;

@Route(value = "students", layout = MainLayout.class)
public class StudentView extends VerticalLayout {

    private List<Student> students = new ArrayList<>();
    private Student selectedStudent = null;

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

    public StudentView() {

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

        totalStudentsCard.add(totalStudentsText);

        // Form Fields
        TextField nameField = new TextField("Student Name");

        ComboBox<String> departmentField = new ComboBox<>("Department");
        departmentField.setItems(
                "Software Engineering",
                "Computer Science",
                "Information Systems"
        );

        ComboBox<Integer> yearField = new ComboBox<>("Year");
        yearField.setItems(1, 2, 3, 4, 5);

        TextField sectionField = new TextField("Section");

        // Button
        Button addButton = new Button(
                "Save Student",
                new Icon(VaadinIcon.PLUS)
        );

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
                    new Icon(VaadinIcon.EDIT)
            );

            editButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);

            editButton.addClickListener(e -> {

                Dialog dialog = new Dialog();

                dialog.setHeaderTitle("Edit Student");

                // Edit Fields
                TextField editNameField =
                        new TextField("Student Name");

                editNameField.setValue(student.getName());

                ComboBox<String> editDepartmentField =
                        new ComboBox<>("Department");

                editDepartmentField.setItems(
                        "Software Engineering",
                        "Computer Science",
                        "Information Systems"
                );

                editDepartmentField.setValue(student.getDepartment());

                ComboBox<Integer> editYearField =
                        new ComboBox<>("Year");

                editYearField.setItems(1, 2, 3, 4, 5);

                editYearField.setValue(student.getYear());

                TextField editSectionField =
                        new TextField("Section");

                editSectionField.setValue(student.getSection());

                // Save Button
                Button saveEditButton = new Button(
                        "Save Changes",
                        new Icon(VaadinIcon.CHECK)
                );

                saveEditButton.addThemeVariants(
                        ButtonVariant.LUMO_PRIMARY
                );

                saveEditButton.addClickListener(event -> {

                    student.setName(editNameField.getValue());
                    student.setDepartment(
                            editDepartmentField.getValue()
                    );
                    student.setYear(editYearField.getValue());
                    student.setSection(
                            editSectionField.getValue()
                    );

                    refreshGrid(grid, searchField);

                    Notification.show("Student Updated!");

                    dialog.close();
                });

                dialog.setWidth("500px");
                dialog.setHeight("650px");

                VerticalLayout dialogLayout = new VerticalLayout(
                        title,
                        nameField,
                        departmentField,
                        yearField,
                        sectionField,
                        saveEditButton
                );

                dialogLayout.setSpacing(true);
                dialogLayout.setPadding(true);

                dialogLayout.getStyle()
                        .set("padding", "30px")
                        .set("gap", "20px");

                nameField.setWidthFull();
                departmentField.setWidthFull();
                yearField.setWidthFull();
                sectionField.setWidthFull();
                saveEditButton.setWidthFull();

                dialog.add(dialogLayout);

                dialog.open();
            });

            Button deleteButton = new Button(
                    "Delete",
                    new Icon(VaadinIcon.TRASH)
            );

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
                addButton
        );

        // Button Click Event
        addButton.addClickListener(e -> {

            // Validation
            if (nameField.isEmpty()
                    || departmentField.isEmpty()
                    || yearField.isEmpty()
                    || sectionField.isEmpty()) {

                Notification.show("Please fill all fields!");
                return;
            }

            // EDIT EXISTING STUDENT
            if (selectedStudent != null) {

                selectedStudent.setName(nameField.getValue());
                selectedStudent.setDepartment(departmentField.getValue());
                selectedStudent.setYear(yearField.getValue());
                selectedStudent.setSection(sectionField.getValue());

                Notification.show("Student Updated!");

                selectedStudent = null;

            } else {

                // ADD NEW STUDENT
                Student student = new Student();

                student.setName(nameField.getValue());
                student.setDepartment(departmentField.getValue());
                student.setYear(yearField.getValue());
                student.setSection(sectionField.getValue());

                students.add(student);

                Notification.show("Student Added!");
            }

            // Refresh Grid
            refreshGrid(grid, searchField);
            totalStudentsText.setText("Total Students: " + students.size());

            // Clear Fields
            nameField.clear();
            departmentField.clear();
            yearField.clear();
            sectionField.clear();
        });

        // Add Components To Page
        add(title, totalStudentsCard, searchField, formLayout, grid);

        // Layout Settings
        setSpacing(true);
        setPadding(true);
    }
}
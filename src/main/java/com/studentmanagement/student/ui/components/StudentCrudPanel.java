package com.studentmanagement.student.ui.components;

import com.studentmanagement.student.model.Student;
import com.studentmanagement.student.service.StudentService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class StudentCrudPanel extends VerticalLayout {

    private final StudentService studentService;
    private final Binder<Student> binder = new Binder<>(Student.class);
    private final Grid<Student> grid = new Grid<>(Student.class, false);
    private final TextField searchField = new TextField();
    private final MetricCard totalStudentsCard;
    private Student selectedStudent;

    public StudentCrudPanel(StudentService studentService) {
        this.studentService = studentService;
        this.totalStudentsCard = new MetricCard("Total Students", String.valueOf(studentService.getTotalStudents()), "200px");

        setSpacing(true);
        setPadding(false);
        setWidthFull();

        H1 title = new H1("Student Management System");

        TextField nameField = new TextField("Student Name");
        ComboBox<String> departmentField = new ComboBox<>("Department");
        departmentField.setItems("Software Engineering", "Computer Science", "Information Systems");

        ComboBox<Integer> yearField = new ComboBox<>("Year");
        yearField.setItems(1, 2, 3, 4, 5);

        TextField sectionField = new TextField("Section");

        nameField.setRequiredIndicatorVisible(true);
        departmentField.setRequiredIndicatorVisible(true);
        yearField.setRequiredIndicatorVisible(true);
        sectionField.setRequiredIndicatorVisible(true);

        binder.forField(nameField)
                .asRequired("Student name is required")
                .withValidator(name -> name.trim().length() >= 2, "Student name must be at least 2 characters")
                .bind(Student::getName, Student::setName);

        binder.forField(departmentField)
                .asRequired("Department is required")
                .bind(Student::getDepartment, Student::setDepartment);

        binder.forField(yearField)
                .asRequired("Year is required")
                .bind(Student::getYear, Student::setYear);

        binder.forField(sectionField)
                .asRequired("Section is required")
                .withValidator(section -> section.trim().length() >= 1, "Section is required")
                .bind(Student::getSection, Student::setSection);

        binder.setBean(new Student());

        Button saveButton = new Button("Save Student", new Icon(VaadinIcon.PLUS));
        saveButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        searchField.setPlaceholder("Search students...");
        searchField.setWidth("300px");
        searchField.setClearButtonVisible(true);
        searchField.addValueChangeListener(event -> refreshGrid());

        grid.addColumn(Student::getName).setHeader("Name");
        grid.addColumn(Student::getDepartment).setHeader("Department");
        grid.addColumn(Student::getYear).setHeader("Year");
        grid.addColumn(Student::getSection).setHeader("Section");
        grid.addComponentColumn(student -> createActionButtons(student, totalStudentsCard))
                .setHeader("Actions");

        HorizontalLayout formLayout = new HorizontalLayout(
                nameField,
                departmentField,
                yearField,
                sectionField,
                saveButton
        );
        formLayout.setWidthFull();

        saveButton.addClickListener(event -> {
            if (!binder.validate().isOk()) {
                return;
            }

            if (selectedStudent != null) {
                studentService.updateStudent(selectedStudent);
                Notification.show("Student Updated!");
                selectedStudent = null;
            } else {
                studentService.addStudent(binder.getBean());
                Notification.show("Student Added!");
            }

            binder.setBean(new Student());
            totalStudentsCard.setValue(String.valueOf(studentService.getTotalStudents()));
            refreshGrid();
        });

        add(title, totalStudentsCard, searchField, formLayout, grid);
        refreshGrid();
    }

    private HorizontalLayout createActionButtons(Student student, MetricCard totalStudentsCard) {
        Button editButton = new Button("Edit", new Icon(VaadinIcon.EDIT));
        editButton.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
        editButton.addClickListener(event -> {
            selectedStudent = student;
            binder.setBean(student);
            Notification.show("Editing student: " + student.getName());
        });

        Button deleteButton = new Button("Delete", new Icon(VaadinIcon.TRASH));
        deleteButton.addThemeVariants(ButtonVariant.LUMO_ERROR);
        deleteButton.addClickListener(event -> {
            studentService.deleteStudent(student);
            if (selectedStudent == student) {
                selectedStudent = null;
                binder.setBean(new Student());
            }

            totalStudentsCard.setValue(String.valueOf(studentService.getTotalStudents()));
            refreshGrid();
            Notification.show("Student Deleted!");
        });

        return new HorizontalLayout(editButton, deleteButton);
    }

    private void refreshGrid() {
        String searchText = searchField.getValue();
        if (searchText == null || searchText.isBlank()) {
            grid.setItems(studentService.getAllStudents());
            return;
        }

        grid.setItems(studentService.searchByName(searchText));
    }
}
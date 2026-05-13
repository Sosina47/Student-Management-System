package com.studentmanagement.student.mock;

import com.studentmanagement.student.model.Student;

import java.util.ArrayList;
import java.util.List;

public final class MockStudentData {

    private MockStudentData() {
    }

    public static List<Student> createStudents() {
        List<Student> students = new ArrayList<>();

        students.add(new Student(1, "Amina Tesfaye", "Software Engineering", 3, "A"));
        students.add(new Student(2, "Hana Mekonnen", "Computer Science", 2, "B"));
        students.add(new Student(3, "Mekdes Abebe", "Information Systems", 4, "A"));
        students.add(new Student(4, "Samson Getachew", "Software Engineering", 1, "C"));
        students.add(new Student(5, "Liya Tadesse", "Computer Science", 5, "B"));
        students.add(new Student(6, "Dawit Kassa", "Information Systems", 2, "D"));

        return students;
    }

    public static int countDepartments() {
        return (int) createStudents().stream()
                .map(Student::getDepartment)
                .distinct()
                .count();
    }
}
package com.studentmanagement.student.service;

import com.studentmanagement.student.mock.MockStudentData;
import com.studentmanagement.student.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final List<Student> students;

    public StudentService() {
        this.students = MockStudentData.createStudents();
    }

    /**
     * Get all students
     */
    public List<Student> getAllStudents() {
        return students;
    }

    /**
     * Add a new student
     */
    public void addStudent(Student student) {
        if (student.getId() <= 0) {
            student.setId(nextId());
        }
        students.add(student);
    }

    /**
     * Update an existing student
     */
    public void updateStudent(Student student) {
        students.stream()
                .filter(s -> s.getId() == student.getId())
                .findFirst()
                .ifPresent(s -> {
                    s.setName(student.getName());
                    s.setDepartment(student.getDepartment());
                    s.setYear(student.getYear());
                    s.setSection(student.getSection());
                });
    }

    /**
     * Delete a student
     */
    public void deleteStudent(Student student) {
        students.remove(student);
    }

    /**
     * Get total count of students
     */
    public int getTotalStudents() {
        return students.size();
    }

    /**
     * Get count of unique departments
     */
    public int countDepartments() {
        return (int) students.stream()
                .map(Student::getDepartment)
                .distinct()
                .count();
    }

    /**
     * Search students by name
     */
    public List<Student> searchByName(String name) {
        String searchText = name == null ? "" : name.trim().toLowerCase();

        if (searchText.isEmpty()) {
            return getAllStudents();
        }

        return students.stream()
                .filter(student -> student.getName() != null &&
                        student.getName().toLowerCase().contains(searchText))
                .toList();
    }

    private int nextId() {
        return students.stream()
                .mapToInt(Student::getId)
                .max()
                .orElse(0) + 1;
    }
}

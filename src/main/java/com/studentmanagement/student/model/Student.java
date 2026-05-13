package com.studentmanagement.student.model;

public class Student {

    private int id;
    private String name;
    private String department;
    private int year;
    private String section;

    public Student() {
    }

    public Student(int id, String name, String department, int year, String section) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.year = year;
        this.section = section;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
package org.epam.entity;


import java.util.Map;


public class Student {

    private int id;
    private String name;
    private int programId;
    private Map<String, Integer> marks;
    private double avgGrade;

    public Student() {
    }

    public Student(int id, String name, int programId, Map<String, Integer> marks, double avgGrade) {
        this.id = id;
        this.name = name;
        this.programId = programId;
        this.marks = marks;
        this.avgGrade = avgGrade;
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

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public Map<String, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<String, Integer> marks) {
        this.marks = marks;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", programId=" + programId +
                ", marks=" + marks +
                ", avgGrade=" + avgGrade +
                '}';
    }
}

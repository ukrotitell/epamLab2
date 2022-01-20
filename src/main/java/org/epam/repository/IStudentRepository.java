package org.epam.repository;

import org.epam.entity.Student;

import java.util.Map;

public interface IStudentRepository {
    void addStudent(Student student);
    void showStudents();
    Student findStudentById(int id);
    void updateStudent(int index, Student student);
    void removeStudent(int id);
    double calculateAvgGrade(Student student);
    void filterStudents();
    void sortByName();
    void sortByAvgGrade();
    void createReport();
    Map<Integer, Double> getGradesReport();
}

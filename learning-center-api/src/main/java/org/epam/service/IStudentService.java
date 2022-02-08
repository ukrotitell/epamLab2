package org.epam.service;


import org.epam.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface IStudentService {
    void addStudent(Student student);
    Student findStudentById(int id);
    void updateStudent(int index, Student student);
    List<Student> removeStudent(int id);
    double calculateAvgGrade(Student student);
    List<Student> filterStudents();
    List<Student> sortByNameOrAvgGrade(Comparator<Student> comparator, List<Student> list);
    Map<Integer, Double> getGradesReport();
    List<Student> getListOfStudents();
}

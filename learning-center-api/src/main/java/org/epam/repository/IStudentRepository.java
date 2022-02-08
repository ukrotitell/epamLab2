package org.epam.repository;


import org.epam.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public interface IStudentRepository {
    void addStudent(Student student);
    List<Student> showStudents();
    Student findStudentById(int id);
    void updateStudent(int index, Student student);
    List<Student> removeStudent(int id) ;
    List<Student> filterStudents();
    List<Student> sortByNameOrAvgGrade(Comparator<Student> comparator, List<Student> list);
    Map<Integer, Double> getGradesReport();
    List<Student> getListOfStudents();
}

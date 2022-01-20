package org.epam.service;

import org.epam.entity.Student;
import org.epam.repository.IStudentRepository;

import java.util.Map;

public class StudentService implements IStudentService{
    private IStudentRepository studentRepository;

    public StudentService(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    @Override
    public void showStudents() {
        studentRepository.showStudents();
    }

    @Override
    public Student findStudentById(int id) {
        return studentRepository.findStudentById(id);
    }

    @Override
    public void updateStudent(int index, Student student) {
        studentRepository.updateStudent(index, student);
    }

    @Override
    public void removeStudent(int id) {
        studentRepository.removeStudent(id);
    }

    @Override
    public double calculateAvgGrade(Student student) {
        return studentRepository.calculateAvgGrade(student);
    }

    @Override
    public void filterStudents() {
        studentRepository.filterStudents();
    }

    @Override
    public void sortByName() {
        studentRepository.sortByName();
    }

    @Override
    public void sortByAvgGrade() {
        studentRepository.sortByAvgGrade();
    }

    @Override
    public void createReport() {
        studentRepository.createReport();
    }

    @Override
    public Map<Integer, Double> getGradesReport() {
        return studentRepository.getGradesReport();
    }
}

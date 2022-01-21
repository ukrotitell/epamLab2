package org.epam.repository;

import org.epam.entity.Student;
import org.epam.util.StudentsWriter;
import org.epam.util.StudentsFile;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentRepository implements IStudentRepository {

    private StudentsFile studentsFile = new StudentsFile();
    private List<Student> listOfStudents = studentsFile.readStudents();
    private StudentsWriter studentsWriter = new StudentsWriter();

    @Override
    public void addStudent(Student student) {
        listOfStudents.add(student);
        showStudents();
    }

    @Override
    public void showStudents() {
        for (int i = 0; i < listOfStudents.size(); i++) {
            System.out.println(listOfStudents.get(i));
        }
    }

    @Override
    public Student findStudentById(int id) {
        for (int i = 0; i < listOfStudents.size(); i++) {
            if (listOfStudents.get(i).getId() == id) {
                return listOfStudents.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateStudent(int index, Student student) {
        listOfStudents.set(index, student);
        showStudents();
    }

    @Override
    public void removeStudent(int id) {
        Student student = findStudentById(id);
        listOfStudents.remove(student);
        showStudents();
    }

    @Override
    public double calculateAvgGrade(Student student) {
        Map<String, Integer> marks = student.getMarks();
        double avgGrade = marks.values().stream().mapToDouble(d -> d).sum() / marks.size();
        return avgGrade;
    }

    @Override
    public void filterStudents() {
        Predicate<Student> byGrade = student -> student.getAvgGrade() >= 75;
        listOfStudents.stream().filter(byGrade)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    @Override
    public void sortByName() {
        listOfStudents = listOfStudents.stream().sorted(Comparator.comparing(Student::getName)).collect(Collectors.toList());
        showStudents();
    }

    @Override
    public void sortByAvgGrade() {
        listOfStudents = listOfStudents.stream().sorted(Comparator.comparing(Student::getAvgGrade).reversed()).collect(Collectors.toList());
        showStudents();
    }

    @Override
    public void createReport() {
        studentsWriter.writeInFile(listOfStudents);
    }

    @Override
    public Map<Integer, Double> getGradesReport() {
        Map<Integer, Double> mapOfStudentsAndGrades = new HashMap<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            mapOfStudentsAndGrades.put(listOfStudents.get(i).getId(), listOfStudents.get(i).getAvgGrade());
        }
        return mapOfStudentsAndGrades;
    }

    @Override
    public int returnStudentIndex(Student student) {
        return listOfStudents.indexOf(student);
    }


}

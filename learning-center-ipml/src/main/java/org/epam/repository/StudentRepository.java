package org.epam.repository;


import org.epam.Student;
import org.epam.exception.IllegalInitialDataException;
import org.epam.util.StudentsParser;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentRepository implements IStudentRepository {

    private String path = "src/main/resources/students.json";
    private StudentsParser studentsFile;
    private List<Student> listOfStudents;

    public StudentRepository() {
    }

    public StudentRepository(StudentsParser studentsFile) {
        this.studentsFile = studentsFile;
        listOfStudents = studentsFile.readStudents(path);
    }

    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    @Override
    public void addStudent(Student student) {
        listOfStudents.add(student);
        showStudents();
    }

    @Override
    public List<Student> showStudents() {
        for (int i = 0; i < listOfStudents.size(); i++) {
            System.out.println(listOfStudents.get(i));
        }
        return listOfStudents;
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
    public List<Student> removeStudent(int id) {
        if (listOfStudents.size() == 0){
            try {
                throw new IllegalInitialDataException("Лист пустой, нечего удалять");
            } catch (IllegalInitialDataException e) {
                e.printStackTrace();
            }
        }
        Student student = findStudentById(id);
        listOfStudents.remove(student);
        showStudents();
        return listOfStudents;
    }

    @Override
    public List<Student> filterStudents() {
        Predicate<Student> byGrade = student -> student.getAvgGrade() >= 75;
        return listOfStudents.stream().filter(byGrade)
                .collect(Collectors.toList());
    }

    @Override
    public List<Student> sortBy(Comparator<Student> comparator, List<Student> list) {

        return list.stream().sorted(comparator).collect(Collectors.toList());
    }



    @Override
    public Map<Integer, Double> getGradesReport() {
        Map<Integer, Double> mapOfStudentsAndGrades = new HashMap<>();
        for (int i = 0; i < listOfStudents.size(); i++) {
            mapOfStudentsAndGrades.put(listOfStudents.get(i).getId(), listOfStudents.get(i).getAvgGrade());
        }
        return mapOfStudentsAndGrades;
    }


}

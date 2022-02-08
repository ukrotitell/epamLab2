package org.epam.repository;

import org.epam.Student;
import org.epam.service.IStudentService;
import org.epam.util.Comparators;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class StudentServiceTest {


    @Mock
    private IStudentRepository studentRepository;

    private IStudentService studentService;

    private Student student1 = new Student(1, "Oleg", 1, Map.of("module1", 50), 50.0);
    private Student student2 = new Student(2, "Dima", 1, Map.of("module2", 70), 70.0);
    private Student student3 = new Student(3, "Marina", 1, Map.of("module2", 90), 90.0);
    private List<Student> students = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.studentService = new StudentService(studentRepository);
        students.add(student1);
        students.add(student2);
    }

    @Test
    void addStudent() {
        studentService.addStudent(student3);
        verify(studentRepository, times(1)).addStudent(student3);
    }


    @Test
    void findStudentById() {
        when(studentRepository.findStudentById(1)).thenReturn(student1);
        Student student = studentService.findStudentById(1);
        assertEquals("Oleg", student.getName());
    }

    @Test
    void updateStudent() {
        student1.setName("OOOOleg");
        studentService.updateStudent(student1.getId(), student1);
        verify(studentRepository, times(1)).updateStudent(1, student1);
        student1.setName("Oleg");
    }

    @Test
    void removeStudent() {
        studentService.removeStudent(student1.getId());
        verify(studentRepository, times(1)).removeStudent(1);
    }

    @Test
    void calculateAvgGrade() {
        double avgGrade = studentService.calculateAvgGrade(student1);
        assertEquals(50.0, avgGrade);
    }

    @Test
    void filterStudents() {
        List<Student> returnList = List.of();
        Mockito.when(studentRepository.filterStudents()).thenReturn(returnList);
        List<Student> result = studentService.filterStudents();
        assertEquals(returnList, result);
    }

    @Test
    void sortByName() {
        Comparator<Student> sortByName = new Comparators().getSortByName();
        List<Student> returnList = List.of(student2, student1);
        Mockito.when(studentRepository.sortByNameOrAvgGrade(sortByName, students)).thenReturn(returnList);
        List<Student> result = studentService.sortByNameOrAvgGrade(sortByName, students);
        assertEquals(returnList, result);
    }

    @Test
    void sortByAvgGrade() {
        Comparator<Student> sortByAvgGrade = new Comparators().getSortByAvgGrade();
        List<Student> returnList = List.of(student2, student1);
        Mockito.when(studentRepository.sortByNameOrAvgGrade(sortByAvgGrade, students)).thenReturn(returnList);
        List<Student> result = studentService.sortByNameOrAvgGrade(sortByAvgGrade, students);
        assertEquals(returnList, result);
    }

    @Test
    void getGradesReport() {
        Mockito.when(studentRepository.getGradesReport()).thenReturn(Map.of(1, 33.0));
        Map<Integer, Double> map = studentService.getGradesReport();
        assertEquals(33.0, map.get(1));
    }

}
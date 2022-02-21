package org.epam.repository;

import org.epam.Student;
import org.epam.util.Comparators;
import org.epam.util.StudentsParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

public class StudentRepositoryTest {

    private StudentRepository studentRepository;
    @Mock
    private StudentsParser studentsParser;

    Comparators comparators = new Comparators();

    static Student student1 = new Student(1, "Oleg", 1, Map.of("module1", 80), 80.0);
    static Student student2 = new Student(2, "Igor", 1, Map.of("module2", 70), 70.0);
    static Student student3 = new Student(2, "Marina", 1, Map.of("module2", 90), 90.0);

    private List<Student> students = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        students.add(student1);
        students.add(student2);
        MockitoAnnotations.openMocks(this);
        Mockito.when(studentsParser.readStudents(anyString())).thenReturn(students);
        this.studentRepository = new StudentRepository(this.studentsParser);
    }

    @Test
    void addStudent() {
        studentRepository.addStudent(student3);
        assertEquals(3, studentRepository.getListOfStudents().size());
    }

    //тест перезаписывается
    @Test
    void showStudents() {
        assertEquals("[Student(id=1, name=Oleg, programId=1, marks={module1=80}, avgGrade=80.0), Student(id=2, name=Igor, programId=1, marks={module2=70}, avgGrade=70.0)]",
                studentRepository.showStudents().toString());
    }

    //возвращем ожидаемое значение
    @Test
    void findStudentById() {
        Student student = studentRepository.findStudentById(2);
        assertEquals(student.getId(), 2);
    }


    //создать нового студента и его заменить на существующего
    @Test
    void updateStudent() {
        Student student = studentRepository.getListOfStudents().get(0);
        student.setName("Karl");
        studentRepository.updateStudent(0, student);
        assertThat(student.getName(), equalTo("Karl"));
        student.setName("Oleg");
    }


    @ParameterizedTest(name = "number")
    @ValueSource(ints = {1, 2})
    void removeStudent(int id) {
        int startSize = studentRepository.getListOfStudents().size();
        studentRepository.removeStudent(id);
        assertEquals(startSize - 1, studentRepository.getListOfStudents().size());

    }

    @Test
    void filterStudents() {
        List<Student> studentList = studentRepository.filterStudents();
        assertEquals(1, studentList.size());
    }

    @Test
    void sortByName() {
        List<Student> studentList = studentRepository.sortBy(comparators.getSortByAvgGrade(), studentRepository.getListOfStudents());
        assertEquals("Igor", studentList.get(0).getName());
    }

    @Test
    void sortByAvgGrade() {
        List<Student> studentList = studentRepository.sortBy(comparators.getSortByAvgGrade(), studentRepository.getListOfStudents());
        assertEquals(70.0, studentList.get(0).getAvgGrade());
    }

    @Test
    void getGradesReport() {
        Map<Integer, Double> mapOfStudentsAndGrades = studentRepository.getGradesReport();
        double grade = 0;
        for (Map.Entry<Integer, Double> pair : mapOfStudentsAndGrades.entrySet()) {
            grade += pair.getValue();
        }
        assertEquals(150.0, grade);
    }

}
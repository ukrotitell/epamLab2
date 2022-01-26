import entity.Program;
import org.epam.util.ProgramsParser;
import org.epam.repository.StudentRepository;
import org.epam.operations.Operations;
import repository.IStudentRepository;
import org.epam.util.ConsoleOperations;
import service.IStudentService;
import org.epam.repository.StudentService;

import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        IStudentRepository studentRepository = new StudentRepository();
        IStudentService studentService = new StudentService(studentRepository);
        ConsoleOperations consoleOperations = new ConsoleOperations();
        Operations operations = new Operations(studentService);
        //
        ProgramsParser programsParser = new ProgramsParser();
        List<Program> programs = programsParser.getListOfPrograms();
        System.out.println(programs);
        //



        do {
            System.out.println("Выберите операцию:");
            System.out.println("1 - добавить студента");
            System.out.println("2 - исключить студента");
            System.out.println("3 - поставить оценку за тест по теме");
            System.out.println("4 - рассчитать количество дней до завершения программы");
            System.out.println("5 - рассчитать и вывести отчет об успеваемости");
            System.out.println("6 - рассчитать возможность отчисления студента");
            System.out.println("7 - просмотреть список всех студентов");
            System.out.println("8 - фильтровать список студентов по условию «Есть вероятность, что не будет отчислен»");
            System.out.println("9 - сформировать общий отчет о студентах в .txt файле");

            int number = consoleOperations.readIntFromConsole();
            if (number==1){
                operations.addStudent();
            }
            if (number==2){
                operations.removeStudentFromList();
            }
            if (number==3){
                operations.setMark();
            }
            if (number==4){
                operations.countNumberOfDays();
            }
            if (number==5){
                operations.getGradesReport();
            }
            if (number==6){
                operations.checkGradesAchievement();
            }
            if (number==7){
                operations.sortStudents();
            }
            if (number==8){
                operations.filterStudents();
            }
            if (number==9){
                operations.createReport();
            }
        } while (!consoleOperations.readStringFromConsole().equals("exit"));
    }
}


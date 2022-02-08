package org.epam.util;

import org.epam.Program;
import org.epam.exception.IllegalInitialDataException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProgramsParserTest {
    @Mock
    ProgramsParser programsParser = new ProgramsParser();

    static Program program1 = new Program(1, "Math", List.of());
    static Program program2 = new Program(2, "Math", List.of());
    List<Program> listOfPrograms = new ArrayList<>();

    @BeforeEach
    public void setUp() throws FileNotFoundException, IllegalInitialDataException {
        listOfPrograms.add(program2);
        listOfPrograms.add(program1);
        MockitoAnnotations.openMocks(this);
        Mockito.when(programsParser.getListOfPrograms()).thenReturn(listOfPrograms);
    }

    @Test
    void getListOfPrograms() throws FileNotFoundException, IllegalInitialDataException {
        List<Program> programs = programsParser.getListOfPrograms();
        assertEquals(2, programs.size());

    }
}
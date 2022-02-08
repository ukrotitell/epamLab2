package org.epam;

import org.epam.repository.StudentRepositoryTest;
import org.epam.util.StudentsWriterTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({StudentRepositoryTest.class, StudentsWriterTest.class})
public class TestSuite {
}

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SubjectHandlerTest {

    //1
    @Test
    void SubjectHandler_viewSubjects() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Scanner testScanner = new Scanner(String.valueOf(1));
        MenuController input = new MenuController(testScanner);
        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input,operator,displayHandler);

        operator.addSubject(subject);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        subjectHandler.handleSubjects();

        System.setOut(originalOut);

        String capturedOutput = output.toString();

        assertTrue(capturedOutput.contains("OOP | COMP503 | 15 credits"));

    }

    @Test
    void SubjectHandler_addSubjects() {

        Scanner testScanner = new Scanner("2\nOOP\nCOMP503\n15\n~\n");
        MenuController input = new MenuController(testScanner);
        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input,operator,displayHandler);

        subjectHandler.handleSubjects();

        Subject checker = operator.findSubject("OOP");

        assertEquals("OOP",checker.getSubjectName());
        assertEquals("COMP503",checker.getSubjectCode());
        assertEquals(15,checker.getCredits());
        assertNotNull(checker);

        Subject checker1 = operator.findSubject("MATH");
        assertNull(checker1);

    }

}
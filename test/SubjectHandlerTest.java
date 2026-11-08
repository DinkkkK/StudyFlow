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

        try {

            System.setOut(new PrintStream(output));
            subjectHandler.handleSubjects();

        } finally {

            System.setOut(originalOut);

        }

        String capturedOutput = output.toString();
        assertTrue(capturedOutput.contains("OOP | COMP503 | 15 credits"));

    }

    //2
    @Test
    void SubjectHandler_addSubjects() {

        Scanner testScanner = new Scanner("2\nOOP\nCOMP503\n15\n~\n");
        MenuController input = new MenuController(testScanner);
        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input,operator,displayHandler);

        subjectHandler.handleSubjects();

        Subject checker = operator.findSubject("OOP");

        assertNotNull(checker);
        assertEquals("OOP",checker.getSubjectName());
        assertEquals("COMP503",checker.getSubjectCode());
        assertEquals(15,checker.getCredits());

    }

    //3
    @Test
    void SubjectHandler_removeSubject() {

        Subject subject1 = new Subject("OOP", "COMP503", 15);
        Subject subject2 = new Subject("MATH", "MATH503",25);
        Scanner testScanner = new Scanner("3\nMATH");
        MenuController input = new MenuController(testScanner);
        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input,operator,displayHandler);

        operator.addSubject(subject1);
        operator.addSubject(subject2);

        subjectHandler.handleSubjects();

        Subject findSubject1 = operator.findSubject("MATH");
        assertNull(findSubject1);

        Subject findSubject2 = operator.findSubject("OOP");
        assertNotNull(findSubject2);

    }

    //4
    @Test
    void SubjectHandler_findSubject() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Scanner testScanner = new Scanner("4\nOOP");
        MenuController input = new MenuController(testScanner);

        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input, operator, displayHandler);

        operator.addSubject(subject);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {

            System.setOut(new PrintStream(output));
            subjectHandler.handleSubjects();

        } finally {

            System.setOut(originalOut);

        }

        String capturedOutput = output.toString();
        assertTrue(capturedOutput.contains("Subject found successfully!"));
        assertTrue(capturedOutput.contains("OOP"));

    }

    //6
    @Test
    void SubjectHandler_findSubjectNotFound() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Scanner testScanner = new Scanner("4\nMath");
        MenuController input = new MenuController(testScanner);

        SubjectOperator operator = new SubjectOperator();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input, operator, displayHandler);

        operator.addSubject(subject);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;

        try {

            System.setOut(new PrintStream(output));
            subjectHandler.handleSubjects();

        } finally {

            System.setOut(originalOut);

        }

        String capturedOutput = output.toString();
        assertTrue(capturedOutput.contains("Subject not found!"));

    }

}
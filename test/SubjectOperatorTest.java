import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubjectOperatorTest {

    //1
    @Test
    void addSubject_returnsTrueWhenSubjectIsNew() {
        SubjectOperator operator = new SubjectOperator();
        Subject subjects = new Subject("Computing in Society", "Math503", 15);

        boolean check = operator.addSubject(subjects);

        assertTrue(check);

    }

    //2
    @Test
    void addSubject_returnsFalseWhenSubjectIsDuplicate() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject1 = new Subject("Computing in Society", "Math503", 15);
        Subject subject2 = new Subject("Computing in Society", "Math503", 15);



        operator.addSubject(subject1);
        assertFalse(operator.addSubject(subject2));
    }

    //3
    @Test
    void addSubject_doesNotIncreaseIfSubjectIsDuplicate() {
        SubjectOperator operator = new SubjectOperator();

        Subject subject1 = new Subject("Computing in Society", "Math503", 15);
        Subject subject2 = new Subject("Computing in Society", "Math503", 15);

        operator.addSubject(subject1);
        operator.addSubject(subject2);

        assertEquals(1, operator.countSubjects());

    }

    //4
    @Test
    void findSubject_returnsSubjectWhenFound() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject1 = new Subject("Computing in Society", "Math503", 15);

        operator.addSubject(subject1);
        Subject checker = operator.findSubject("Computing in Society");


        assertEquals("Computing in Society", checker.getSubjectName());
        assertEquals("Math503", checker.getSubjectCode());
    }

    //5
    @Test
    void findSubject_returnsNullWhenSubjectIsNotFound() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject1 = new Subject("Computing in Society", "Math503", 15);

        operator.addSubject(subject1);
        Subject checker = operator.findSubject("Object Oriented Programming");


        assertNull(checker);

    }

    //6
    @Test
    void removeSubject_returnsTrueWhenSubjectIsRemoved() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject = new Subject("Computing in Society", "Math503", 15);

        operator.addSubject(subject);
        boolean removeSubject = operator.removeSubject("Computing in Society");

         assertTrue(removeSubject);

    }

    //7
    @Test
    void removeSubject_DecreaseIfSubjectIsRemoved() {
        SubjectOperator operator = new SubjectOperator();

        Subject subject1 = new Subject("Computing in Society", "Math503", 15);
        Subject subject2 = new Subject("Object Oriented Programming", "COMP503", 15);
        Subject subject3 = new Subject("AI", "AI432", 15);

        operator.addSubject(subject1);
        operator.addSubject(subject2);
        operator.addSubject(subject3);
        operator.removeSubject("Object Oriented Programming");

        assertEquals(2, operator.countSubjects());

    }

    //8
    @Test
    void removeSubject_returnsFalseWhenSubjectIsNotFound() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject = new Subject("Computing in Society", "Math503", 15);

        operator.addSubject(subject);
        boolean removeSubject = operator.removeSubject("Object Oriented Programming");

        assertFalse(removeSubject);

    }

    //9
    @Test
    void removeSubject_subjectVerificator() {
        SubjectOperator operator = new SubjectOperator();
        Subject subject1 = new Subject("Computing in Society", "Math503", 15);
        Subject subject2 = new Subject("Object Oriented Programming", "Comp503", 15);

        operator.addSubject(subject1);
        operator.addSubject(subject2);
        boolean removeSubject = operator.removeSubject("Object Oriented Programming");
        Subject checker = operator.findSubject("Computing in Society");

        assertTrue(removeSubject);
        assertNull(operator.findSubject("Object Oriented Programming"));
        assertEquals("Computing in Society", checker.getSubjectName());

    }





}
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SubjectTest {

    ///1
    @Test
    void addAssignment_addsAssignmentToList() {
        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment = new Assignment("Ass1", "1.2.3", "4.5.6");

        subject.addAssignment(assignment);

        ArrayList <Assignment> assignments = subject.getAssignments();

        assertTrue(assignments.contains(assignment));
    }

    //2
    @Test
    void addAssignment_addsMultipleAssignmentsToList() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment1 = new Assignment("ass1", "1.2.3", "4.5.6");
        Assignment assignment2 = new Assignment("ass2", "1.2.3", "4.5.6");
        Assignment assignment3 = new Assignment("ass3", "1.2.3", "4.5.6");

        subject.addAssignment(assignment1);
        subject.addAssignment(assignment2);
        subject.addAssignment(assignment3);

        ArrayList<Assignment> assignments = subject.getAssignments();

        assertTrue(assignments.contains(assignment1));
        assertTrue(assignments.contains(assignment2));
        assertTrue(assignments.contains(assignment3));
        assertEquals(3, assignments.size());
    }

    //3
    @Test
    void removeAssignment_returnsTrueWhenAssignmentIsRemoved() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment = new Assignment("ass1", "1.2.3", "4.5.6");

        subject.addAssignment(assignment);
        boolean removedAssignment = subject.removeAssignment("ass1");

        assertTrue(removedAssignment);

    }

    //4
    @Test
    void removeAssignment_returnsFalseWhenAssignmentIsNotRemoved() {
        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment = new Assignment("ass1", "1.2.3", "4.5.6");

        subject.addAssignment(assignment);
        boolean removedAssignment = subject.removeAssignment("ass2");


        assertFalse(removedAssignment);

    }

    //5
    @Test
    void removeAssignment_decreaseIfAssignmentIsRemoved() {
        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment1 = new Assignment("ass1", "1.2.3", "4.5.6");
        Assignment assignment2 = new Assignment("ass2", "1.2.3", "4.5.6");


        subject.addAssignment(assignment1);
        subject.addAssignment(assignment2);
        subject.removeAssignment("ass2");

        ArrayList <Assignment> assignments = subject.getAssignments();

        assertEquals(1, assignments.size());

    }

    //6
    @Test
    void removeAssignment_OnlyRemovesSpecifiedAssignment() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment1 = new Assignment("ass1", "1.2.3", "4.5.6");
        Assignment assignment2 = new Assignment("ass2", "1.2.3", "4.5.6");
        Assignment assignment3 = new Assignment("ass3", "1.2.3", "4.5.6");

        subject.addAssignment(assignment1);
        subject.addAssignment(assignment2);
        subject.addAssignment(assignment3);
        subject.removeAssignment("ass3");

        ArrayList<Assignment> assignments = subject.getAssignments();

        assertTrue(assignments.contains(assignment1));
        assertTrue(assignments.contains(assignment2));
        assertFalse(assignments.contains(assignment3));

    }

    //7
    @Test
    void findAssignment_returnsAssignmentWhenFound() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment1 = new Assignment("ass1", "1.2.3", "4.5.6");

        subject.addAssignment(assignment1);
        Assignment foundAssignment = subject.findAssignment("ass1");

        assertSame(foundAssignment, assignment1);

    }

    //8
    @Test
    void findAssignment_returnsNullWhenAssignmentIsNotFound() {

        Subject subject = new Subject("OOP", "COMP503", 15);
        Assignment assignment1 = new Assignment("ass1", "1.2.3", "4.5.6");

        subject.addAssignment(assignment1);
        Assignment foundAssignment = subject.findAssignment("ass2");

        assertNull(foundAssignment);

    }

}
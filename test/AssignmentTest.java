import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AssignmentTest {

    //1
    @Test
    void constructor_initializesAssignmentField() {
        Assignment assignment = new Assignment("ass1", "1.2.3", "4.5.6");

        assertEquals("ass1",assignment.getTitle());
        assertEquals("1.2.3",assignment.getGivenDate());
        assertEquals("4.5.6",assignment.getDueDate());

    }

    //2
    @Test
    void setAssignment_updateAssignmentFields() {
        Assignment assignment = new Assignment("ass1", "1.2.3", "4.5.6");

        assignment.setTitle("ass2");
        assignment.setGivenDate("7.8.9");
        assignment.setDueDate("10.11.12");

        assertEquals("ass2",assignment.getTitle());
        assertEquals("7.8.9",assignment.getGivenDate());
        assertEquals("10.11.12",assignment.getDueDate());

    }

}
import java.util.ArrayList;

public class DisplayHandler {

    private SubjectOperator operator;

    public DisplayHandler(SubjectOperator operator) {
        this.operator = operator;
    }

    public void displaySubjects(){

        ArrayList<Subject> subjects = operator.returnSubjects();

        if(subjects.isEmpty()){
            System.out.println("No subjects found!");
            return;
        }

        for (Subject subject : subjects) {
            System.out.println(subject.getSubjectName() + " | " +
                    subject.getSubjectCode() + " | " +
                    subject.getCredits() + " credits");

        }

    }

    public void displayAssignments(Subject subject){

        ArrayList<Assignment> assignments = subject.returnAssignment();

        if(assignments.isEmpty()){
            System.out.println("No assignment found!");
            return;
        }

        for (Assignment assignment : assignments) {
            System.out.println(assignment.getTitle() + " | " +
                    assignment.getGivenDate() + " | " +
                    assignment.getDueDate());

        }


    }
}


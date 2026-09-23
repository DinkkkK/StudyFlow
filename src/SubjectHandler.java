import java.util.ArrayList;

public class SubjectHandler {

    private MenuController input;
    private SubjectOperator operator;
    private DisplayHandler displayHandlers;


    public SubjectHandler(MenuController input, SubjectOperator operator, DisplayHandler displayHandlers) {
        this.input = input;
        this.operator = operator;
        this.displayHandlers = displayHandlers;
    }

    public void handleSubjects() {
        System.out.println("1. View Subjects");
        System.out.println();
        System.out.println("2. Add Subjects");
        System.out.println();
        System.out.println("3. Delete Subjects");
        System.out.println();
        System.out.println("4. Find a Subject");
        System.out.print("Select: ");

        int option = input.getInteger();

        switch (option) {
            case 1 -> {
                viewAllSubjects();
            }
            case 2 -> {
                addSubject();
            }
            case 3 -> {
                removeSubject();
            }
            case 4 -> {
                findSubject();
            }
            default -> {
                System.out.println("Invalid input! Try again");
            }
        }
    }


    private void addSubject() {
        while (true) {
            System.out.println("Enter subject name: (press ~ to exit)");
            String subject = input.getString();

            if (subject.equals("~")) {
                System.out.println("Thank you!");
                break;
            }

            while (subject.isEmpty()) {
                System.out.println("Please don't leave this blank!");
                subject = input.getString();
            }

            System.out.println("Enter subject code: ");
            String subjectCode = input.getString();

            System.out.println("Enter credits for subject: ");
            int subjectCredits = input.getInteger();


            boolean added = operator.addSubject(new Subject(subject, subjectCode, subjectCredits));

            if (added) {
                System.out.println("Subject added!");
            } else {
                System.out.println("Subject already exists!");
            }

        }

    }

    private void viewAllSubjects() {
        System.out.println("Your Subjects:");

       displayHandlers.displaySubjects();
    }

    private void removeSubject() {
        System.out.println("Which subject do you want to remove?");

        displayHandlers.displaySubjects();

        String subjectIdentifier = input.getString();

        if (operator.removeSubject(subjectIdentifier)) {
            System.out.println("Subject removed successfully!");
            System.out.println();
            System.out.println("Your current subjects: ");

           displayHandlers.displaySubjects();

        } else {
            System.out.println("Subject not found!");
        }
    }

    private void findSubject() {
        System.out.println("What subject are you looking for?");
        String searchFor = input.getString();

        Subject foundSubject = operator.findSubject(searchFor);

        if (foundSubject != null) {
            System.out.println("Subject found successfully!");
            System.out.println(foundSubject.getSubjectName());

        } else {
            System.out.println("Subject not found!");
        }


    }
}




import java.util.ArrayList;

public class DashboardHandler {

    private MenuController input;
    private SubjectOperator operator;
    private DisplayHandler displayGetters;

    public DashboardHandler(MenuController input, SubjectOperator operator, DisplayHandler displayGetters) {
        this.input = input;
        this.operator = operator;
        this.displayGetters = displayGetters;
    }

    public void handleDashboard() {
        System.out.println("Current Subjects:");
        int numberOfSubjects = operator.countSubjects();
        System.out.println(numberOfSubjects);
        System.out.println("1. Add Assignment");
        System.out.println();
        System.out.println("2. View Assignments");
        System.out.println();
        System.out.println("3. Remove Assignments");
        System.out.println();
        System.out.println("4. Change Assignment");
        int options = input.getIntegers();

        switch (options) {
            case 1 -> {
                addAssignment();
            }
            case 2 -> {
                viewAssignment();
            }
            case 3 -> {
                removeAssignment();
            }
            case 4 -> {
                changeAssignment();
            }
            default -> {
                System.out.println("Invalid input! Try again");
            }
        }
    }

    private void addAssignment() {

        while (true) {
            System.out.println("Which subject would you like to add an assignment in? (press ~ to quit)");

            Subject subject = selectSubject();

            if (subject == null) {
                return;
            } else {

                System.out.println("What assignment do you want to add? (press ~ to quit)");
                String title = input.getStrings();

                if (title.equals("~")) {
                    break;
                }

                System.out.println("When is it given?");
                String givenDate = input.getStrings();

                System.out.println("When is the deadline?");
                String dueDate = input.getStrings();

                subject.addAssignment(new Assignment(title, givenDate, dueDate));
                System.out.println("Assignments added successfully!");

                displayGetters.displayAssignments(subject);

            }
        }
        System.out.println("Thank you!");
    }

    public void viewAssignment() {
        System.out.println("Which subject would you like to view assignments for? (press ~ to quit)");

        Subject subject = selectSubject();

        if(subject == null){
            return;
        }

            System.out.println("Assignment for: " + subject.getSubjectName());

            displayGetters.displayAssignments(subject);


    }

    private void removeAssignment() {
        System.out.println("Which subject do you want to remove an assignment from? (press ~ to quit)");

        Subject subject = selectSubject();

        if (subject != null) {

            ArrayList<Assignment> assignments = subject.returnAssignment();

            if (assignments.isEmpty()) {

                System.out.println("No assignment for this subject, well done!");

            } else {

                System.out.println("Here are your listed assignments:");

                displayGetters.displayAssignments(subject);

                System.out.print("Which assignment do you want to remove? (press ~ to quit)");
                String selectedAssignment = input.getStrings();

                if (selectedAssignment.equals("~")) {
                    System.out.println("Thank you!");
                    return;
                }

                boolean removedAssignment = subject.removeAssignment(selectedAssignment);

                if (removedAssignment) {

                    System.out.println("Assignment removed successfully!");
                    System.out.println("Here is your updated list: ");

                    displayGetters.displayAssignments(subject);

                } else {
                    System.out.println("Sorry this assignment does not exist!");
                }
            }

        } else {
            System.out.println("Subject does not exist! Please try again!");
        }


    }

    private void changeAssignment() {

        System.out.println("Which subject do you want to edit an assignment on? (press ~ to quit)");

       Subject subject = selectSubject();

        if (subject != null) {

            displayGetters.displayAssignments(subject);

            System.out.println("Please choose an assignment you want to edit: (press ~ to quit)");

            displayGetters.displayAssignments(subject);

            String chosenAssignment = input.getStrings();


            if (chosenAssignment.equals("~")) {
                System.out.println("Thank you!");
                return;
            }

            Assignment findAssignment = subject.findAssignment(chosenAssignment);

            if (findAssignment != null) {

                System.out.println("Assignment Name(NEW): ");
                String assignmentName = input.getStrings();

                if (assignmentName.equals("~")) {
                    System.out.println("Thank you!");
                    return;
                }

                System.out.println("Given Date(NEW): ");
                String givenDate = input.getStrings();

                System.out.println("Due Date(NEW): ");
                String dueDate = input.getStrings();

                findAssignment.setTitle(assignmentName);
                findAssignment.setGivenDate(givenDate);
                findAssignment.setDueDate(dueDate);

                System.out.println("Assignment changed successfully!");

                System.out.println("Here is your updated assignment list: ");

                displayGetters.displayAssignments(subject);

            } else {
                System.out.println("Assignment not found! Please try again.");
            }


        } else {
            System.out.println("Subject not found! Please try again.");
        }

    }

    private Subject selectSubject() {
        displayGetters.displaySubjects();

        String chosenSubject = input.getStrings();

        if(chosenSubject.equals("~")){
            System.out.println("Goodbye");
            return null;
        }

        Subject findSubject = operator.findSubject(chosenSubject);

        if(findSubject == null){
            System.out.println("Subject cannot be found! Please try again");
            return null;
        }
            return findSubject;
        }
    }







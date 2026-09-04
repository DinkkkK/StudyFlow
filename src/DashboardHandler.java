import java.util.ArrayList;

public class DashboardHandler {

    private MenuController input;
    private SubjectOperator operator;

    public DashboardHandler(MenuController input, SubjectOperator operator) {
        this.input = input;
        this.operator = operator;
    }

    public void handleDashboard() {
        System.out.println("Current Subjects:");
        int numberOfSubjects = operator.countSubjects();
        System.out.println(numberOfSubjects);
        System.out.println("1. Add Assignment");
        System.out.println();
        System.out.println("2. View Assignments");
        System.out.println();
        System.out.println("3. Study Planner");
        System.out.println();
        System.out.println("4. Coming Soon");
        int options = input.getIntegers();

        switch (options) {
            case 1 -> {
                addAssignment();
            }
            case 2 -> {
                viewAssignment();
            }
            case 3 -> {
                System.out.println("3. Coming Soon");
            }
            case 4 -> {
                System.out.println("4. Study Planner");
            }
            default -> {
                System.out.println("Invalid input! Try again");
            }
        }
    }

    private void addAssignment() {

        while (true) {
            System.out.println("Which subject would you like to add an assignment in? (press ~ to quit)");

            ArrayList <Subject> subjectInfo = operator.returnSubjects();

            for(Subject subject : subjectInfo){
                System.out.println(subject.getSubjectName() + " | " +
                        subject.getSubjectCode() + " | " +
                        subject.getCredits());
            }

            String subject = input.getStrings();

            if (subject.equals("~")) {
                break;
            }

            Subject findSubject = operator.findSubject(subject);

            if (findSubject != null) {

                System.out.println("What assignment do you want to add? (press ~ to quit)");
                String title = input.getStrings();

                if (title.equals("~")) {
                    break;
                }

                System.out.println("When is it given?");
                String givenDate = input.getStrings();

                System.out.println("When is the deadline?");
                String dueDate = input.getStrings();

                findSubject.addAssignment(new Assignment(title, givenDate, dueDate));
                System.out.println("Assignments added successfully!");

                ArrayList <Assignment> assignmentInfo = findSubject.returnAssignment();

                for(int i = 0; i < assignmentInfo.size(); i++){
                    System.out.println(assignmentInfo.get(i).getTitle() + " | " +
                            assignmentInfo.get(i).getGivenDate() + " | " +
                            assignmentInfo.get(i).getDueDate());
                }

            } else {
                System.out.println("Subject not found!");


            }
        }

        System.out.println("Thank you!");
    }

    public void viewAssignment() {
        System.out.println("Which subject would you like to view assignments for?");

        ArrayList<Subject> subjectInfo = operator.returnSubjects();

        for(Subject subject : subjectInfo){
            System.out.println(subject.getSubjectName() + " | " +
                    subject.getSubjectCode() + " | " +
                    subject.getCredits());
        }

        String subject = input.getStrings();

        Subject findSubject = operator.findSubject(subject);

            if(findSubject != null){
                System.out.println("Assignment for: " + findSubject.getSubjectName());

                ArrayList <Assignment> assignmentInfo = findSubject.returnAssignment();

                for(int i = 0; i < assignmentInfo.size(); i++){
                    System.out.println(assignmentInfo.get(i).getTitle() + " | " +
                                       assignmentInfo.get(i).getGivenDate() + " | " +
                                        assignmentInfo.get(i).getDueDate());
                }

            } else {
                    System.out.println("Subject not Found!");

            }
        }
    }


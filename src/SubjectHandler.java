
public class SubjectHandler {

    private MenuController input;
    private SubjectList subs;


    public SubjectHandler(MenuController input, SubjectList subs) {
        this.input = input;
        this.subs = subs;
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

        int option = input.getIntegers();

        switch (option) {
            case 1 -> {
                viewAllSubject();
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
            String subject = input.getStrings();

            while (subject.isEmpty()) {
                System.out.println("Please don't leave this blank!");
                subject = input.getStrings();
            }

            if (subject.equals("~")){
                System.out.println("Thank you!");
                break;
            }

            System.out.println("Enter subject code: ");
            String subjectCode = input.getStrings();

            System.out.println("Enter credits for subject: ");
            int subjectCredits = input.getIntegers();


            boolean added = subs.addSubject(new Subject(subject, subjectCode, subjectCredits));

                if(added) {
                    System.out.println("Subject added!");
                } else {
                    System.out.println("Subject already exists!");
                }

            }

            }


    private void viewAllSubject(){
        System.out.println("Your Subjects:");
        subs.displaySubjects();
        System.out.println();
    }

    private void removeSubject(){
        System.out.println("Which subject do you want to remove?");
        subs.displaySubjects();
        String subject = input.getStrings();

        if(subs.removeSubject(subject)){
            System.out.println("Subject removed successfully!");
            System.out.println();
            System.out.println("Your current subjects: ");
            subs.displaySubjects();
        } else {
            System.out.println("Subject not found!");
        }
    }

    private void findSubject(){
        System.out.println("What subject are you looking for?");
        String searchFor = input.getStrings();

        Subject foundSubject = subs.findSubject(searchFor);

        if(foundSubject != null){
            System.out.println("Subject found successfully!");
            System.out.println(foundSubject.getSubjectName());

        } else {
            System.out.println("Subject not found!");
        }


    }

    }


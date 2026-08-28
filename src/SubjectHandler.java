
public class SubjectHandler {

    private MenuController input;
    private SubjectList subs;


    public SubjectHandler(MenuController input, SubjectList subs){
        this.input = input;
        this.subs = subs;
    }

    public void handleSubjects(){
        System.out.println("1. View Subjects");
        System.out.println();
        System.out.println("2. Add Subjects");
        System.out.println();
        System.out.println("3. Delete Subjects");
        System.out.println();
        System.out.println("4. Find a Subject");
        System.out.print("Select: ");

        int option = input.getIntegers();

        switch(option){
            case 1 -> {
                viewAllSubject();
            }
            case 2 -> {
                addSubject();
            }
            case 3 -> {
                removeSubject();
            }
            case 4 ->{
                findSubject();
            }
            default -> {
                System.out.println("Invalid input! Try again");
            }
        }
    }


    private void addSubject(){
        while (true) {

            System.out.println("Please enter the name of the subjects you want to add.");
            String subject = input.getStrings();

            while(subject.isEmpty()){
                System.out.println("Don't leave this blank!");
                subject = input.getStrings();
            }

            subs.addSubject(new Subject(subject));
            System.out.println("Subject added successfully!");

            System.out.println("Would you like to add another subject? (Y/N)");
            String answer = input.getStrings();

            while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")){
                System.out.println("Invalid input! Try again");
                answer = input.getStrings();
            }

            if(answer.equalsIgnoreCase("Y")) {
                while (true) {

                    System.out.println("Please enter another subject! (Press ~) to exit.");
                    subject = input.getStrings();

                    while(subject.isEmpty()){
                        System.out.println("Don't leave this blank!");
                        subject = input.getStrings();
                    }

                    if (subject.equals("~")) {
                        System.out.println("Thank you!");
                        return;
                    }

                    subs.addSubject(new Subject(subject));
                    System.out.println("Subject added successfully!");

                }
            } else {
                System.out.println("Thank you!");
                return;
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
            System.out.printf(foundSubject.getSubjectName());

        } else {
            System.out.println("Subject not found!");
        }


    }

    }


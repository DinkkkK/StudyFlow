
public class Version1 {

    public static void main(String[] args) {
        SubjectList subjects = new SubjectList();
        MenuController input = new MenuController();
        MainMenu menu = new MainMenu();

        //title to showcase name
        Introduction intro = new Introduction();
        intro.printIntroduction();

        System.out.print("<press Enter key>");
       String enter = input.getStrings();

        //prevents user to enter invalid texts
        while(true) {
            if(enter.isEmpty()){
                //menu tab to showcase options
                 menu.showMenu();
                    int option = input.getIntegers();

                    switch(option){
                        case 1 -> {
                            Dashboard(subjects, input);
                        }
                        case 2 -> {
                            Subjects(subjects, input);
                        }
                        case 3 -> {
                            System.out.println("Thank you for using StudyFlow!");
                            return;
                        }
                        default -> {
                                System.out.println("Invalid Option!");
                        }
                    }
               } else {
                System.out.println("Invalid input! Try again");
                enter = input.getStrings();
            }
            }
        }

    static public void Subjects(SubjectList sub, MenuController input) {
        System.out.println("1. View Subjects");
        System.out.println();
        System.out.println("2. Add Subject Subjects");
        System.out.println();
        System.out.println("3. Delete Subjects");
        System.out.println();
        System.out.print("Select: ");
        int option = input.getIntegers();

        switch(option) {

            case 1 -> {
                System.out.println("Your Subjects:");
                sub.displaySubjects();
                System.out.println();
            }
            case 2 -> {

                while (true) {
                    System.out.println("Please enter the name of the subjects you want to add.");
                    String subject = input.getStrings();
                    sub.addSubject(new Subject(subject));
                    System.out.println("Subject added successfully!");

                    if (subject.isEmpty()) {
                        System.out.println("Please enter a subject name!");
                        subject = input.getStrings();
                        sub.addSubject(new Subject(subject));
                    }

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

                            if (subject.equals("~")) {
                                System.out.println("Thank you!");
                                return;
                            }

                                sub.addSubject(new Subject(subject));
                                System.out.println("Subject added successfully!");

                        }
                    } else {
                        System.out.println("Thank you!");
                        return;
                    }

                }


            }
            case 3 -> {
                System.out.println("Which subject do you want to remove?");
                sub.displaySubjects();
                String subject = input.getStrings();

                if(sub.removeSubject(subject)){
                    System.out.println("Subject removed successfully!");
                    System.out.println();
                    System.out.println("Your current subjects: ");
                    sub.displaySubjects();
                } else {
                    System.out.println("Subject not found!");
                }
            }
            default -> {
                System.out.println("Invalid input! Try again");
            }

        }
    }

    static public void Dashboard(SubjectList sub, MenuController input){
        System.out.println("Current Subjects:");
        sub.countSubjects();
        int numberOfSubjects = sub.countSubjects();
        System.out.println(numberOfSubjects);
        System.out.println("Assignments");
        System.out.println();
        System.out.println("Coming Soon");
        System.out.println();
        System.out.println("Study Planner");
        System.out.println();
        System.out.println("Coming Soon");
    }

}


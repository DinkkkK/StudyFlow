import java.util.Scanner;
public class Version1 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        SubjectList subjects = new SubjectList();

        //title to showcase name
        Introduction intro = new Introduction();
        intro.printIntroduction();

        System.out.print("<press Enter key>");
        String enter = scanner.nextLine();

        //prevents user to enter invalid texts
        while(true) {
            if(enter.isEmpty()){
                //menu tab to showcase option
                    System.out.println("=================================================");
                    System.out.println("                   MAIN MENU                     ");
                    System.out.println("=================================================");
                    System.out.println();
                    System.out.println("1. Dashboard");
                    System.out.println();
                    System.out.println("2. Subjects");
                    System.out.println();
                    System.out.println("3. Exit");
                    System.out.println();
                    System.out.print("Select: ");
                    int option = Integer.valueOf(scanner.nextLine());

                    switch(option){
                        case 1 -> {
                            Dashboard(subjects);
                        }
                        case 2 -> {
                            Subjects(subjects);
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
                enter = scanner.nextLine();
            }
            }
        }

   static public void Subjects(SubjectList sub) {

        System.out.println("1. View Subjects");
        System.out.println();
        System.out.println("2. Add Subject Subjects");
        System.out.println();
        System.out.println("3. Delete Subjects");
        System.out.println();
        System.out.print("Select: ");
        int option = Integer.valueOf(scanner.nextLine());

        switch(option) {

            case 1 -> {
                System.out.println("Your Subjects:");
                sub.displaySubjects();
                System.out.println();
            }
            case 2 -> {

                while (true) {
                    System.out.println("Please enter the name of the subjects you want to add.");
                    String subject = scanner.nextLine();
                    sub.addSubject(new Subject(subject));
                    System.out.println("Subject added successfully!");

                    if (subject.isEmpty()) {
                        System.out.println("Please enter a subject name!");
                        subject = scanner.nextLine();
                        sub.addSubject(new Subject(subject));
                    }

                    System.out.println("Would you like to add another subject? (Y/N)");
                    String answer = scanner.nextLine();

                    while(!answer.equalsIgnoreCase("Y") && !answer.equalsIgnoreCase("N")){
                        System.out.println("Invalid input! Try again");
                        answer = scanner.nextLine();
                    }

                    if(answer.equalsIgnoreCase("Y")) {
                        while (true) {

                            System.out.println("Please enter another subject! (Press ~) to exit.");
                            subject = scanner.nextLine();

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
                String subject = scanner.nextLine();

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

    static public void Dashboard(SubjectList sub){
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


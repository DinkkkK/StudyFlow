
public class Version1 {

    public static void main(String[] args) {
        SubjectList subjects = new SubjectList();
        MenuController input = new MenuController();
        SubjectHandler subjectHandler = new SubjectHandler(input, subjects);
        MenuHandler menuHandler = new MenuHandler();

        //title to showcase name
        Introduction intro = new Introduction();
        intro.printIntroduction();

        System.out.print("<press Enter key>");
       String enter = input.getStrings();

        //prevents user to enter invalid texts
        while(true) {
            if(enter.isEmpty()){
                //menu tab to showcase options
                    menuHandler.showMainMenu();
                    int option = input.getIntegers();

                    switch(option){
                        case 1 -> {
                            Dashboard(subjects, input);
                        }
                        case 2 -> {
                            subjectHandler.handleSubjects();
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

    static public void Dashboard(SubjectList sub, MenuController input){
        System.out.println("Current Subjects:");
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


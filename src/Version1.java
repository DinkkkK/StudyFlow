
public class Version1 {

    public static void main(String[] args) {
        SubjectOperator operator = new SubjectOperator();
        MenuController input = new MenuController();
        SubjectHandler subjectHandler = new SubjectHandler(input, operator);
        MenuHandler menuHandler = new MenuHandler();
        DashboardHandler dashboardHandler = new DashboardHandler(input, operator);

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
                            dashboardHandler.handleDashboard();
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

}


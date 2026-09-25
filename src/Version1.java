
public class Version1 {

    public static void main(String[] args) {
        SubjectOperator operator = new SubjectOperator();
        MenuController input = new MenuController();
        DisplayHandler displayHandler = new DisplayHandler(operator);
        SubjectHandler subjectHandler = new SubjectHandler(input, operator, displayHandler);
        MenuHandler menuHandler = new MenuHandler();
        DashboardHandler dashboardHandler = new DashboardHandler(input, operator, displayHandler);

        Introduction intro = new Introduction();
        intro.printIntroduction();

        System.out.print("<press Enter key>");
        String startProgram = input.getString();

        while (!startProgram.isEmpty()) {

            System.out.println("Invalid input! Try again");
            startProgram = input.getString();
        }

        while (true) {
            menuHandler.showMainMenu();
            int option = input.getInteger();

            switch (option) {
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
        }
    }
}




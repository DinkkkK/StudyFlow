import java.util.Scanner;

public class MenuController {
    private Scanner scanner;

    public MenuController() {
        this.scanner = new Scanner(System.in);
    }

    public MenuController(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getString() {
        return scanner.nextLine();
    }

    public int getInteger() {

        while(true) {
            try {
                return Integer.valueOf(scanner.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Please input a number!");
            }
        }
    }
}

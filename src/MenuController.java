import java.util.Scanner;

public class MenuController {
    private Scanner scanner;

    public MenuController(){
        this.scanner = new Scanner(System.in);
    }

    public String getString(){
        return scanner.nextLine();
    }

    //will fix using try logic
    public int getInteger(){
        return Integer.valueOf(scanner.nextLine());
    }
}

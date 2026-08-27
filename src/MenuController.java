import java.util.Scanner;

//handles inputs for main class
public class MenuController {
    private Scanner sc;

    public MenuController(){
        this.sc = new Scanner(System.in);
    }

    public String getStrings(){
        String string = sc.nextLine();
        return string;
    }

    public int getIntegers(){
        int integer = Integer.valueOf(sc.nextLine());
        return integer;
    }

}

package converter;

import java.util.Scanner;

public class Menu {

    SubMenu subMenu = new SubMenu();
    Scanner sc = new Scanner(System.in);
    String input = "";
    String number;
    int base;

    public void run() {
        do {
            System.out.println("Enter two numbers in format:" +
                    " {source base} {target base} (To quit type /exit)");
            input = sc.nextLine();
            switch (input) {
                case "/exit":
                    break;
                default:
                    subMenu.run(Integer.parseInt(input.split(" ")[0]),
                            Integer.parseInt(input.split(" ")[1]));
                    break;
            }
        } while (!input.equals("/exit"));
    }
}

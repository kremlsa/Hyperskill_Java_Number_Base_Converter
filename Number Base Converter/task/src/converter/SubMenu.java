package converter;

import java.util.Scanner;

public class SubMenu {
    Converter conv = new Converter();
    Scanner sc = new Scanner(System.in);
    String input = "";

    public void run(int oldRadix, int newRadix) {
        do {
            System.out.println("Enter number in base " +
                    oldRadix + " to convert to base " + newRadix  +
                    " (To go back type /back) ");
            input = sc.nextLine();
            switch (input) {
                case "/back":
                    break;
                default:
                    System.out.println("Conversion result: "
                            + conv.conv(oldRadix, input, newRadix));
                    break;
            }
        } while (!input.equals("/back"));
    }
}

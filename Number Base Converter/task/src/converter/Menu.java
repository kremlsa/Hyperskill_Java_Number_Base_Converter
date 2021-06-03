package converter;

import java.util.Scanner;

public class Menu {

    Converter conv = new Converter();
    Scanner sc = new Scanner(System.in);
    String input = "";
    String number;
    int base;

    public void run() {
        do {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit) ");
            input = sc.nextLine();
            switch (input) {
                case "/from":
                    System.out.print("Enter a number in decimal system: ");
                    number = sc.nextLine();
                    System.out.print("Enter the target base: ");
                    base = Integer.parseInt(sc.nextLine());
                    System.out.println("Conversion result: "
                            + conv.conv(10, number, base));
                    break;
                case "/to":
                    System.out.print("Enter source number: ");
                    number = sc.nextLine();
                    System.out.print("Enter source base: ");
                    base = Integer.parseInt(sc.nextLine());
                    System.out.println("Conversion to decimal result: "
                            + conv.conv(base, number, 10));
                    break;
                default:
                    break;
            }
        } while (!input.equals("/exit"));
    }
}

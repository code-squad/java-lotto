package calculator;

import java.util.Scanner;

public class ConsoleInput {

    public static String getUserInput() {
        System.out.println("input calculate string");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        return userInput;

    }
}

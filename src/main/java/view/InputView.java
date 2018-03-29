package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class InputView {

    public static int putMoney(){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> putAnswer() {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(",");
        return Arrays.stream(temp).mapToInt(i -> Integer.parseInt(i)).boxed().collect(Collectors.toList());
    }
}

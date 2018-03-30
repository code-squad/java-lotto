package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int LOTTO_COST = 1000;

    public static int buyLotto(){
        Scanner scanner = new Scanner(System.in);
        try {
            return (Integer.parseInt(scanner.nextLine())) / LOTTO_COST;
        } catch (InputMismatchException e){
            System.out.println("올바른 타입을 입력해 주세요.");
            return buyLotto();
        }
    }

    public static List<Integer> putAnswer() {
        Scanner scanner = new Scanner(System.in);
        String[] temp = scanner.nextLine().split(",");
        return Arrays.stream(temp).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    }

}

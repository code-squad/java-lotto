package lotto.view;

import lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class InputView {

    private static final String INPUT_MONEY_PROMPT = "구매금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_PROMPT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_PROMPT = "보너스 번호를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_PROMPT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBER_PROMPT = "수동으로 구매할 번호를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_PROMPT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<int[]> inputManualLottoNumbers() {
        System.out.println(INPUT_MANUAL_LOTTO_COUNT_PROMPT);
        int count = Integer.parseInt(scanner.nextLine());

        System.out.println(INPUT_MANUAL_LOTTO_NUMBER_PROMPT);
        List<int[]> inputNumbers = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            String inputString = scanner.nextLine();
            if(inputString.trim().isEmpty())
                break;
            String[] strNumbers = inputString.split(",");
            inputNumbers.add(Arrays.stream(strNumbers)
                    .mapToInt(v -> Integer.parseInt(v.trim()))
                    .toArray());
        }
        return inputNumbers;
    }

    public static WinningNumber inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_PROMPT);
        String inputString = scanner.nextLine();
        String[] strNumbers = inputString.split(",");
        List<Integer> numbers = Arrays.stream(strNumbers)
                .map(v -> Integer.parseInt(v.trim()))
                .collect(Collectors.toList());

        System.out.println(INPUT_BONUS_NUMBER_PROMPT);
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        return new WinningNumber(numbers, bonusNumber);
    }
}

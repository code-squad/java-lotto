package lotto.view;

import lotto.domain.LottoNumber;

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

    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println(INPUT_MONEY_PROMPT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static LottoNumber inputWinningNumber() {
        System.out.println(INPUT_WINNING_NUMBER_PROMPT);
        String inputString = scanner.nextLine();
        String[] strNumbers = inputString.split(",");
        List<Integer> numbers = Arrays.stream(strNumbers)
                .map(v -> Integer.parseInt(v.trim()))
                .collect(Collectors.toList());
        return new LottoNumber(numbers);
    }
}

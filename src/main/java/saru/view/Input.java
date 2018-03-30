package saru.view;

import saru.domain.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// SonarLint StandOutput warning 방지용
@java.lang.SuppressWarnings("squid:S106")
public class Input {
    private static final int LOTTO_ONE = 1000;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private static final String PROMPT_BUY = "구입금액을 입력해 주세요.";
    private static final String BUY_NUM_RESULT = "%s 개를 구매했습니다.\n\n";
    private static final String PROMPT_HIT_NUM = "지난 주 당첨 번호를 입력해 주세요.\n";

    private static Scanner scanner = new Scanner(System.in);

    private Input() {
        // empty
    }

    public static int promptBuy() {
        System.out.println(PROMPT_BUY);
        int buyNum = Input.buy(scanner.nextInt());
        System.out.printf(BUY_NUM_RESULT, buyNum);

        return buyNum;
    }

    public static String promptHitNumber() {
        scanner.nextLine();
        System.out.println(PROMPT_HIT_NUM);

        return scanner.nextLine();
    }

    public static int buy(int money) {
        return money / LOTTO_ONE;
    }

    public static List<LottoNumber> makeManualLottoNumbers(String numStr) {
        String[] winNumArr = numStr.replaceAll(SPACE, BLANK).split(COMMA);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String str : winNumArr) {
            int toInputNum = Integer.parseInt(str);
            lottoNumbers.add(LottoNumber.of(toInputNum));
        }

        return lottoNumbers;
    }
}

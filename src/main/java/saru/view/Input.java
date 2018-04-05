package saru.view;

import saru.domain.*;

import java.util.*;

// SonarLint StandOutput warning 방지용
@java.lang.SuppressWarnings("squid:S106")
public class Input {
    private static final int LOTTO_ONE = 1000;

    private static final String PROMPT_BUY = "구입금액을 입력해 주세요.";
    private static final String PROMPT_HIT_NUM = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PROMPT_BONUS_NUM = "보너스 번호를 입력하세요.";
    private static final String PROMPT_MANUAL_NUMS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PROMPT_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String BUY_NUM_RESULT = "%s 개를 구매했습니다.\n\n";

    private static Scanner scanner = new Scanner(System.in);
    private static LottoMaker lottoMaker = LottoMaker.of();

    private static int runtime = 0;

    private Input() {
        // empty
    }

    public static int promptBuy() {
        System.out.println(PROMPT_BUY);
        int buyNum = 0;

        try {
            buyNum = Input.buy(scanner.nextInt());
        } catch (IllegalArgumentException e) {
            System.out.println("0이하로 구매할수 없음");
            e.printStackTrace();

            return promptBuy();
        }

        System.out.printf(BUY_NUM_RESULT, buyNum);

        return buyNum;
    }

    public static String promptHitNumber() {
        System.out.println(PROMPT_HIT_NUM);

        String hitNumStr = scanner.nextLine();

        if (runtime != 0) {
            scanner.nextLine();
        }

        runtime++;

        return hitNumStr;
    }

    public static int promptBonusNumber() {
        System.out.println(PROMPT_BONUS_NUM);

        return scanner.nextInt();
    }

    public static int buy(int money) {
        if (money <= 0) {
            throw new IllegalArgumentException("0 이하 금액 입력");
        }

        return money / LOTTO_ONE;
    }

    public static List<LottoLine> manualBuy(List<String> manualNumbersList) {
        List<LottoLine> manualLottoLinesResult = new ArrayList<>();

        for (String toTransString : manualNumbersList) {
            try {
                manualLottoLinesResult.add(lottoMaker.makeManualLottoLine(toTransString));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(e);
            }
        }

        return manualLottoLinesResult;
    }

    public static List<String> manualInputProc() {
        int manualNum = inputManualNum();

        List<String> manualStrings = new ArrayList<>();
        loopManualAdd(manualNum, manualStrings);

        return manualStrings;
    }

    private static int inputManualNum() {
        System.out.println(PROMPT_MANUAL_COUNT);
        int manualNum = scanner.nextInt();
        scanner.nextLine();

        return manualNum;
    }

    private static void loopManualAdd(int manualNum, List<String> manualStrings) {
        for (int i = 0; i < manualNum; i++) {
            System.out.println(PROMPT_MANUAL_NUMS);
            String str = scanner.nextLine();
            manualStrings.add(str);
        }
    }
}

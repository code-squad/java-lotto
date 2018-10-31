package com.zingoworks.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String PHRASE_PURCHASE_AMOUNT = "구입금액을 입력해주세요.";
    private static final String PHRASE_MANUAL_LOTTO_AMOUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PHRASE_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String PHRASE_LAST_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String PHRASE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private static Scanner sc = new Scanner(System.in);

    public static int inputPurchaseAmount() {
        System.out.println(PHRASE_PURCHASE_AMOUNT);
        return sc.nextInt();
    }

    public static int inputManualLottoAmounts() {
        System.out.println(PHRASE_MANUAL_LOTTO_AMOUNT);
        return sc.nextInt();
    }

    public static List<String> inputManualLottoNumbers(int manualLottoAmounts) {
        System.out.println(PHRASE_MANUAL_LOTTO_NUMBER);

        List<String> data = new ArrayList<>();
        for (int i = 0; i < manualLottoAmounts; i++) {
            data.add(sc.next());
        }
        return data;
    }

    public static String inputLastWinningNumbers() {
        System.out.println(PHRASE_LAST_WINNING_NUMBER);
        return sc.next();
    }

    public static int inputBonusNumber() {
        System.out.println(PHRASE_BONUS_NUMBER);
        return sc.nextInt();
    }
}

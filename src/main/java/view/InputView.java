package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String PURCHASE_AMOUNT_INPUT_MSG = "구입금액을 입력해 주세요";
    public static final String NUM_OF_MANUAL_LOTTO_PURCHASE_INPUT_MSG = "수동으로 구매할 로또 수를 입력해 주세요";
    public static final String MANUAL_LOTTO_INPUT_MSG = "수동으로 구매할 번호를 입력해 주세요";
    public static final String WINNING_LOTTO_NUMBERS_INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요";
    public static final String BONUS_NUMBER_INPUT_MSG = "보너스 볼을 입력해 주세요";

    public static int inputPurchaseAmount() {
        Scanner sc = new Scanner(System.in);
        System.out.println(PURCHASE_AMOUNT_INPUT_MSG);
        return sc.nextInt();
    }

    public static int inputNumOfManualLottoPurchase() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(NUM_OF_MANUAL_LOTTO_PURCHASE_INPUT_MSG);
        return sc.nextInt();
    }
    public static List<String> inputManualLotto(int numOfManualLottoPurchase) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(MANUAL_LOTTO_INPUT_MSG);

        List<String> manualLottosStr = new ArrayList<>();
        for (int i = 0; i < numOfManualLottoPurchase; i++) {
            manualLottosStr.add(sc.nextLine());
        }
        return manualLottosStr;
    }

    public static String inputWinningLottoNumbers() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println(WINNING_LOTTO_NUMBERS_INPUT_MSG);
        return sc.nextLine();
    }

    public static int inputBonusNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.println(BONUS_NUMBER_INPUT_MSG);
        return sc.nextInt();
    }
}

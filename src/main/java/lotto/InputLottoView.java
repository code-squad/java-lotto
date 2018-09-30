package lotto;

import lotto.exception.ManualPurchaseLessThanZeroException;
import lotto.exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputLottoView {

    public static Money inputMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }

    public static List<String> inputPurchaseManualLotto(int count) throws IllegalArgumentException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Scanner scanner = new Scanner(System.in);
            manualLottoNumbers.add(scanner.nextLine());
        }
        return manualLottoNumbers;
    }

    public static int inputPurchaseManualLottoCount(Money money) throws IllegalArgumentException {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return checkPurchaseManualLottoCount(scanner.nextInt(), money);
    }

    public static int checkPurchaseManualLottoCount(int manualCount, Money money) {
        if (manualCount < 0) {
            throw new ManualPurchaseLessThanZeroException();
        }

        if (money.isExceedMoney(manualCount)) {
            throw new NotEnoughMoneyException();
        }

        return manualCount;
    }

    public static String inputWinnerNumber() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputBonus(Lotto lotto) throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        return lotto.checkDuplicateBonusNumber(LottoNumber.checkLottoNumberRange(scanner.nextInt()));
    }

}
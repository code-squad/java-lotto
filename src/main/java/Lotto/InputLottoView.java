package Lotto;

import Lotto.Exception.IllegalMonetaryUnitException;
import Lotto.Exception.ManualPurchaseLessThanZeroException;
import Lotto.Exception.NotEnoughMoneyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputLottoView {

    public static Money inputMoney() throws IllegalArgumentException {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return checkInputMoney(new Money(scanner.nextInt()));
    }

    public static Money checkInputMoney(Money money) {
        if (money.isUnavailablePurchase()) {
            throw new NotEnoughMoneyException();
        }

        if (money.isExistRemainder()) {
            throw new IllegalMonetaryUnitException();
        }

        return money;
    }

    public static List<Lotto> inputPurchaseManualLotto(int count) throws IllegalArgumentException {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Scanner scanner = new Scanner(System.in);
            manualLottoNumbers.add(Lotto.makeManualLottoNumber(scanner.nextLine()));
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

    public static Lotto inputWinnerNumber() throws IllegalArgumentException {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return Lotto.makeManualLottoNumber(scanner.nextLine());
    }

    public static int inputBonus(Lotto lotto) throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);
        return lotto.checkDuplicateBonusNumber(LottoNumber.checkLottoNumberRange(scanner.nextInt()));
    }

}
package view;

import domain.Lotto;
import domain.WinningLotto;
import domain.result.LottoNum;
import utils.LottoMachine;
import utils.MoneyUtils;

import java.util.List;
import java.util.Scanner;

import static utils.InputViewUtils.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getTotalAmount() {
        System.out.println("구입금액을 입력해주세요.");
        try {
            return MoneyUtils.calcBuyAmount(convertNumber(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getTotalAmount();
        }
    }

    public static int getManualBuyAmount(int totalAmount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        try {
            int manualAmount = convertNumber(scanner.nextLine());
            verifyManualAmount(totalAmount, manualAmount);
            return manualAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualBuyAmount(totalAmount);
        }
    }



    // TODO : 여기부터 아래 손보기
    public static WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            Lotto lotto = new Lotto(getLottoNumbers());
            LottoNum bonusNumber = getBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    public static List<Lotto> getManualLottoBundle(int amount) {
        if (amount < 0) {
            return null;
        }
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        try {
            return LottoMachine.manualBuy(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLottoBundle(amount);
        }
    }

    public static List<LottoNum> getLottoNumbers() {
        try {
            return convertLottoNum(parseLottoNumbers(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumbers();
        }
    }

    private static LottoNum getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return convertLottoNum(scanner.nextLine());
    }
}

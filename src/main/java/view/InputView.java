package view;

import domain.Lotto;
import domain.WinningLotto;
import utils.LottoMachine;
import utils.MoneyUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public static void verifyManualAmount(int totalAmount, int manualAmount) {
        if (isOverTotalAmount(totalAmount, manualAmount)) {
            throw new IllegalArgumentException("전체 구매개수보다 수동 지정한 개수가 많습니다.");
        }

        if (isNegativeAmount(manualAmount)) {
            throw new IllegalArgumentException("수동 구매 가능 개수(0개 이상 " + totalAmount + "개 이하)");
        }
    }

    public static boolean isOverTotalAmount(int totalAmount, int manualAmount) {
        return totalAmount < manualAmount;
    }

    public static boolean isNegativeAmount(int manualAmount) {
        return manualAmount < 0;
    }

    public static int convertNumber(String numberMessage) {
        try {
            return Integer.parseInt(numberMessage);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력해야합니다.");
        }
    }

    public static List<Integer> convertNumber(String[] numberMessage) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        for (String number : numberMessage) {
            numbers.add(convertNumber(number));
        }
        return numbers;
    }

    public static WinningLotto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        try {
            Lotto lotto = new Lotto(getLottoNumbers());
            int bonusNumber = getBonusNumber();
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

    public static List<Integer> getLottoNumbers() {
        try {
            return convertNumber(parseLottoNumbers(scanner.nextLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoNumbers();
        }
    }

    public static String[] parseLottoNumbers(String lottoNumbers) {
        String spaceRemovedNumbers = removeSpace(lottoNumbers);
        return spaceRemovedNumbers.split(",");
    }

    private static String removeSpace(String lottoNumbers) {
        return lottoNumbers.replaceAll(" ", "");
    }

    private static int getBonusNumber() throws IllegalArgumentException {
        System.out.println("보너스 볼을 입력해 주세요.");
        return convertNumber(scanner.nextLine());
    }
}

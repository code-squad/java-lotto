package javaLotto.view;

import javaLotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static javaLotto.utils.LottoNumberGenerator.makeLottoNumberManual;

public class InputView {
    static Scanner scanner = new Scanner(System.in);

    public static String setPrice() {
        System.out.println("구입금액을 입력해 주세요.");

        return inputStringData();
    }

    public static List<LottoTicket> setManualNumber(int manualBuyCount, int price) {
        if (manualBuyCount > price / 1000) {
            throw new IllegalArgumentException("구매 갯수를 초과했습니다.");
        }
        List<LottoTicket> lottosNumber = new ArrayList<>();
        System.out.println("수동으로 구매할 로또 번호를 입력해주세요 ");
        for (int buyNumber = 0; buyNumber < manualBuyCount; buyNumber++) {
            lottosNumber.add(makeLottoNumberManual(InputView.inputStringData()));
        }
        return lottosNumber;
    }

    public static String setManual() {
        System.out.println("수동으로 구매할 로또 갯수를 입력해주세요 ");
        return inputStringData();
    }

    public static String setWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return inputStringData();
    }

    public static String setBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return inputStringData();
    }

    public static String inputStringData() {
        return scanner.nextLine();
    }

    private static String checkNull(String inputPrice) {
        if (inputPrice == null || inputPrice.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return inputPrice;
    }

}

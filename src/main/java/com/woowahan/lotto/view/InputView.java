package com.woowahan.lotto.view;

import com.woowahan.lotto.model.LottoNo;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return money;
    }

    public Set<LottoNo> inputLuckyNumbers() {
        Set<LottoNo> luckyNumbers = new HashSet<>();

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String[] inputNumbers = scanner.nextLine().split(",");
        for (String inputNumber : inputNumbers) {
            luckyNumbers.add(new LottoNo(Integer.parseInt(inputNumber.trim())));
        }

        return luckyNumbers;
    }

    public LottoNo inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNo(Integer.parseInt(scanner.nextLine()));
    }
}

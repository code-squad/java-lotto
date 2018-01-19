package com.woowahan.lotto.view;

import com.woowahan.lotto.model.LottoNo;
import com.woowahan.lotto.model.WinningLotto;

import java.util.*;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = Integer.parseInt(scanner.nextLine());
        return money;
    }

    public String inputLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public LottoNo inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNo(Integer.parseInt(scanner.nextLine()));
    }
}

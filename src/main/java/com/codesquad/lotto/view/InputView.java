package com.codesquad.lotto.view;

import com.codesquad.lotto.domain.Lotto;
import com.codesquad.lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    public static Money inputPayment() {
        System.out.println("구입금액을 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return parseMoney(scanner.nextLine());
    }

    static Money parseMoney(final String money) {
        try {
            return new Money(Integer.parseInt(money));
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    public static Lotto inputWinLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        final Scanner scanner = new Scanner(System.in);
        return Lotto.fromComma(scanner.nextLine());
    }
}

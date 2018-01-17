package view;

import domain.Lotto;
import domain.LottoNo;
import domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static WinningNumber getWinningLotto() {
        Lotto winningLotto = new Lotto(getWinnerNums());
        LottoNo bonusNo = new LottoNo(getBonusNum());

        return new WinningNumber(winningLotto, bonusNo);
    }
    public static int getInvestMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static List<Integer> getWinnerNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = sc.nextLine().split(", ");

        return toInts(inputs);
    }

    public static int getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static List<Integer> toInts(String[] inputs) {
        List<Integer> winnerNums = new ArrayList<>();
        for(int i = 0 ; i < inputs.length ; i++)
            winnerNums.add(Integer.parseInt(inputs[i]));

        return winnerNums;
    }
}

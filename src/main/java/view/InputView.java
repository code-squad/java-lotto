package view;

import domain.LottoNo;
import domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static WinningNumber getWinningLotto() {
        List<LottoNo> winnerNums = getWinnerNums();
        LottoNo bonusNum = getBonusNum();

        return new WinningNumber(winnerNums, bonusNum);
    }

    public static int getInvestMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static int getNumOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static List<List<LottoNo>> getManualNums(int numOfManualLotto) {
        List<List<LottoNo>> nums = new ArrayList<>(numOfManualLotto);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for(int i = 0 ; i < numOfManualLotto ; ++i)
            nums.add(getNumber());

        return nums;
    }

    private static List<LottoNo> getNumber() {
        String[] inputs = sc.nextLine().split(", ");

        return toLottoNos(inputs);
    }

    private static List<LottoNo> getWinnerNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return getNumber();
    }

    private static LottoNo getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNo(Integer.parseInt(sc.nextLine()));
    }

    private static List<LottoNo> toLottoNos(String[] inputs) {
        List<LottoNo> winnerNums = new ArrayList<>();
        for(int i = 0 ; i < inputs.length ; i++)
            winnerNums.add(new LottoNo(Integer.parseInt(inputs[i])));

        return winnerNums;
    }
}

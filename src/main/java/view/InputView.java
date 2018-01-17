package view;

import domain.*;

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
    public static BuyInfo getBuyInfo() {
        int investMoney = getInvestMoney();
        Lottos manualLotto= getManualLottos(getNumOfManualLotto());

        return new BuyInfo(investMoney, manualLotto);
    }

    private static int getInvestMoney() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static List<Integer> getWinnerNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String[] inputs = sc.nextLine().split(", ");

        return toInts(inputs);
    }

    private static int getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    private static int getNumOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(sc.nextLine());
    }

    public static Lottos getManualLottos(String inputs) {
        String[] lottoInputs = inputs.split("\r\n");
        List<Lotto> lottos = new ArrayList<>(lottoInputs.length);

        for(int i = 0 ; i < lottoInputs.length ; ++i)
            lottos.add(new Lotto(getNumber(lottoInputs[i])));

        return new Lottos(lottos);
    }

    private static Lottos getManualLottos(int numOfManualLotto) {
        List<Lotto> nums = new ArrayList<>(numOfManualLotto);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for(int i = 0 ; i < numOfManualLotto ; ++i)
            nums.add(new Lotto(getNumber()));

        return new Lottos(nums);
    }

    public static List<Integer> getNumber(String input) {
        String[] inputs = input.split(",");

        return toInts(inputs);
    }

    private static List<Integer> getNumber() {
        String[] inputs = sc.nextLine().split(", ");

        return toInts(inputs);
    }

    private static List<Integer> toInts(String[] inputs) {
        List<Integer> winnerNums = new ArrayList<>();
        for(int i = 0 ; i < inputs.length ; i++)
            winnerNums.add(Integer.parseInt(inputs[i]));

        return winnerNums;
    }
}

package view;

import domain.WinningNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static WinningNumber getWinningLotto() {
        List<Integer> winnerNums = getWinnerNums();
        int bonusNum = getBonusNum();

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

    public static List<List<Integer>> getManualNums(int numOfManualLotto) {
        List<List<Integer>> nums = new ArrayList<>(numOfManualLotto);
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");

        for(int i = 0 ; i < numOfManualLotto ; ++i)
            nums.add(getNumber());

        return nums;
    }

    private static List<Integer> getNumber() {
        String[] inputs = sc.nextLine().split(", ");

        return toInts(inputs);
    }

    private static List<Integer> getWinnerNums() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        return getNumber();
    }

    private static int getBonusNum() {
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

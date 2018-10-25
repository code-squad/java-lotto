package lottogame.view;

import lottogame.domain.Lotto;
import lottogame.domain.WinnningLotto;
import lottogame.dto.InputDto;
import lottogame.util.LottoGenerator;
import lottogame.util.NumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static NumberGenerator generator = new LottoGenerator();

    public static InputDto receiveInput() {
        Money money = getMoney();
        int manualAmount = getManualAmount();
        List<Lotto> lottos = generateNumber(money.howManyBuyLotto(), manualAmount);
        printInput(lottos);
        Lotto winningLotto = getWinningNumber();
        int bonus = getBonusNum();
        return new InputDto(money, lottos, WinnningLotto.of(winningLotto, bonus));
    }

    private static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(sc.nextInt());
    }

    private static int getManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    private static List<Lotto> generateNumber(int amount, int manualAmount) {
        if (manualAmount > amount) {
            throw new IllegalArgumentException("지불한 돈보다 수동 입력 로또가 더 많습니다.");
        }

        List<Lotto> list = new ArrayList<>();
        for (int i = 0; i < manualAmount; i++) {
            list.add(getLotto());
        }

        for (int i = 0; i < amount - manualAmount; i++) {
            list.add(new Lotto(generator.generate()));
        }
        return list;
    }

    private static void printInput(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static Lotto getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return getLotto();
    }

    private static int getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    private static Lotto getLotto() {
        return new Lotto(Arrays.stream(sc.next().split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList()));
    }

    public static void clearBuffer(){
        sc.nextLine();
    }
}

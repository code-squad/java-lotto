package lottogame.view;

import lottogame.domain.Lotto;
import lottogame.domain.WinnningLotto;
import lottogame.dto.InputDto;
import lottogame.dto.LottoDto;
import lottogame.util.LottoGenerator;
import lottogame.util.NumberGenerator;
import lottogame.vo.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner sc = new Scanner(System.in);
    private static NumberGenerator randomLottoGenerator = new LottoGenerator();

    public static InputDto console() {
        Money money = getMoney();
        int manualAmount = getManualAmount();
        List<Lotto> lottos = generateLottoByConsoleInput(money.howManyBuyLotto(), manualAmount);
        printInput(lottos);
        Lotto winningLotto = getWinningNumber();
        int bonus = getBonusNum();
        return new InputDto(money, lottos, WinnningLotto.of(winningLotto, bonus));
    }

    public static List<Lotto> web(String inputMoney, String manualNumber) {
        Money money = Money.of(inputMoney);
        List<Lotto> lottos = generateLottoByText(money.howManyBuyLotto(), manualNumber);
        return lottos;
    }

    private static Money getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(sc.nextInt());
    }

    private static int getManualAmount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    private static List<Lotto> generateLottoByConsoleInput(int amount, int manualAmount) {
        if (manualAmount > amount) {
            throw new IllegalArgumentException("지불한 돈보다 수동 입력 로또가 더 많습니다.");
        }

        List<Lotto> lottos = generate(manualAmount, () -> Lotto.ofText(sc.next()));
        lottos.addAll(generateRandomLottos(amount - manualAmount));
        return lottos;
    }

    private static List<Lotto> generateLottoByText(int amount, String manualAmount) {
        String[] splittedManualAmount = manualAmount.split("\r?\n");
        List<Lotto> lottos = Arrays.stream(splittedManualAmount)
                                        .map(Lotto::ofText)
                                        .collect(Collectors.toList());
        lottos.addAll(generateRandomLottos(amount - splittedManualAmount.length));
        return lottos;
    }

    private static List<Lotto> generateRandomLottos(int times) {
        return generate(times, () -> new Lotto(randomLottoGenerator.generate()));
    }

    private static List<Lotto> generate(int time, Supplier<Lotto> supplier) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < time; i++) {
            lottos.add(supplier.get());
        }
        return lottos;
    }

    private static void printInput(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    private static Lotto getWinningNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Lotto.ofText(sc.next());
    }

    private static int getBonusNum() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }

    public static void clearBuffer() {
        sc.nextLine();
    }
}

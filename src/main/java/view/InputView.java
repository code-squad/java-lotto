package view;

import domain.LottoFactory;
import domain.Lottos;

import java.util.Scanner;
import java.util.stream.IntStream;

public class InputView {
    private static Scanner sc = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return sc.nextInt();
    }

    public static int handMakeottosCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return sc.nextInt();
    }

    public static Lottos handMakeLottos(int count) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        sc.nextLine();
        Lottos lottos = new Lottos();
        IntStream.range(0, count).forEach(i -> {
            lottos.add(LottoFactory.makeHandLotto(sc.nextLine()));
        });
        System.out.println();
        return lottos;
    }

    public static String lastAnswerNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return sc.nextLine();
    }

    public static int bonusBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return sc.nextInt();
    }
}

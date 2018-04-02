package input;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.Lotto;

public class Input {
    private List<Lotto> lottos = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private List<String> right;

    public static void rightNumber() {
        System.out.println("지난주의 당첨번호를 입력해주세요.");
    }

    public static void bonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void rightResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public List<Lotto> makeLottos(int num) {
        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            System.out.println(lotto.getLotto());
        }
        return lottos;
    }

    public List<Lotto> addManualLottos(List<String> manual) {
        for(int i = 0; i < manual.size(); i++) {
            Lotto lotto = new Lotto(manual.get(i));
            lottos.add(lotto);
        }
        return lottos;
    }

    public String right() {
        String input = scanner.nextLine();
        return input;
    }
}

package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static Money buyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(new Scanner(System.in).nextInt());
    }

    public static String lastWeekWinNumber() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return new Scanner(System.in).nextLine().trim().replace(" ", "");
    }

    public static LottoNo bonusBall(){
        System.out.println("보너스 볼을 입력해 주세요.");
        return LottoNo.of(new Scanner(System.in).nextInt());
    }

    // 수동 로또
    public static int buyManualLottoCount(Money money){
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int count = new Scanner(System.in).nextInt();
        money.isOverCount(count);
        return count;
    }

    public static List<String> manualLotto(int createCount){
        List<String> manualLottos = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < createCount; i++) {
            manualLottos.add(new Scanner(System.in).nextLine().trim().replace(" ", ""));
        }
        return manualLottos;
    }
}

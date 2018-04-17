package lottoGame.view;

import lottoGame.domain.Lotto;
import lottoGame.domain.LottoNo;

import java.util.*;

public class InputView {

    private static Scanner sc = new Scanner(System.in);

    public static LottoNo inputBonusLottoBall() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return new LottoNo(Integer.valueOf(sc.nextLine()));
    }

    public static int inputLottoPrice() {
        System.out.println("구입금액을 입력해 주새요.");
        int inputLottoPrice = Integer.valueOf(sc.nextLine());
        if(inputLottoPrice <= 0)
            throw new IllegalArgumentException("구입금액은 0원 이상이여야 합니다.");

        return inputLottoPrice;
    }

    public static int inputHandOperatedLottoCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.valueOf(sc.nextLine());
    }

    public static void printHandOperatedLottoGuide() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static List<LottoNo> inputHandOperatedLottoNumbers() {
        List<LottoNo> lottoNums = new ArrayList<>();

        for(String lottoNum:sc.nextLine().split(", ")) {
            lottoNums.add(new LottoNo(Integer.valueOf(lottoNum)));
        }

        return lottoNums;
    }

    public static Set<LottoNo> inputLuckyNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Set<LottoNo> luckyNums = new HashSet<>();
        int i = 0;
        for(String luckNum:sc.nextLine().split(", ")) {
            luckyNums.add(new LottoNo(Integer.valueOf(luckNum)));
        }
        return luckyNums;
    }
}

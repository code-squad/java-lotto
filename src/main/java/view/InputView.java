package view;

import domain.LottoGenerator;
import domain.No;
import dto.LottoDto;
import dto.NoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputCash() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static int buyLotto(int inputCash) {
        int lottoAmt = inputCash / LottoGenerator.LOTTO_PRICE;

        System.out.println(lottoAmt + "개를 구매했습니다.");
        return lottoAmt;
    }

    private static List<NoDto> inputWinnningNumbs() {
        Scanner sc = new Scanner(System.in);

        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbs = sc.nextLine();

        return makeIntNumbs(numbs.split(", "));
    }

    public static NoDto inputBonusNum() {
        Scanner sc = new Scanner(System.in);

        System.out.println("보너스 번호를 입력해 주세요.");
        return NoDto.init(Integer.parseInt(sc.nextLine()));
    }

    private static List<NoDto> makeIntNumbs(String[] numbs) {
        List<NoDto> result = new ArrayList<>();

        for (String numb : numbs) {
            result.add(NoDto.init(Integer.parseInt(numb)));
        }
        return result;
    }

    public static LottoDto getWinningLotto() {
        return LottoDto.init(inputWinnningNumbs());
    }

}

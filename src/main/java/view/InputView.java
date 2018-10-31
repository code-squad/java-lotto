package view;

import dto.LottoDto;
import dto.LottosDto;
import vo.No;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static int inputCash() {
        Scanner sc = new Scanner(System.in);

        System.out.println("구입금액을 입력해주세요.");
        return sc.nextInt();
    }

    public static LottosDto buyLottoManual(int lottoManualAmt) {
        if(lottoManualAmt != 0)
            System.out.println("수동으로 구매할 번호를 입력하세요.");
        return LottosDto.init(makeLottoDtos(lottoManualAmt));
    }

    private static List<LottoDto> makeLottoDtos(int lottoManualAmt) {
        List<LottoDto> lottoDtos = new ArrayList<>();

        for(int i=0; i<lottoManualAmt; i++) {
            lottoDtos.add(LottoDto.init(inputLottoNumbs()));
        }
        return lottoDtos;
    }

    public static int inputLottoManualAmt() {
        Scanner sc = new Scanner(System.in);
        System.out.println("수동으로 구매할 로또의 갯수를 입력하시오.");

        return sc.nextInt();
    }

    private static List<No> inputLottoNumbs() {
        Scanner sc = new Scanner(System.in);
        String numbs = sc.nextLine();

        return makeIntNumbs(numbs.split(", "));
    }

    public static No inputBonusNum() {
        Scanner sc = new Scanner(System.in);

        System.out.println("보너스 번호를 입력해 주세요.");
        return new No(Integer.parseInt(sc.nextLine()));
    }

    private static List<No> makeIntNumbs(String[] numbs) {
        List<No> result = new ArrayList<>();

        for (String numb : numbs) {
            result.add(new No(Integer.parseInt(numb)));
        }
        return result;
    }

    public static LottoDto getWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return LottoDto.init(inputLottoNumbs());
    }

}

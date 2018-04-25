package lottoGame.view;

import lottoGame.model.*;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public static void printLottoGameResult(List<Lotto> lottoGames) {
        for(int i = 0; i < lottoGames.size(); i++) {
            OutputView.printLottoNumbers(numberToStrings(lottoGames.get(i).getLottoNumbersToList()));;
        }
    }

    private static void printLottoNumbers (List<String> lottoNumbers) {
        System.out.println("[" + String.join(" ,", lottoNumbers + "]"));
    }

    public static void printLottoGameResult(GameResult result) {
        System.out.println("당첨통계");
        System.out.println("---------");

        for(int i = 0; i< result.resultStrings.size(); i++) {
            System.out.println(result.resultStrings.get(i));
        }

        System.out.println("총 수익률은 : " + result.profitMoney + "%입니다.");
    }

    private static List<String> numberToStrings(List<LottoNumbers> numbers) {
        List<String> numbersValues = new ArrayList<String>();
        for(int i = 0; i < numbers.size(); i++) {
            numbersValues.add(numbers.get(i).toString());
        }
        return numbersValues;
    }
}

import java.util.*;

public class LottoView {
    public static void cards(List<Card> cards){
        for (Card card : cards){
            System.out.println(card.getNumbers());
        }
    }

    public static void announce(LottoResult lottoResult) {
        printResult(lottoResult.getResult());
        printBenefit(lottoResult.getBenefit());
    }

    private static void printResult(Map<Integer, Integer> result) {
        result.forEach((key, value) -> System.out.println(key + "번 일치:" + value + "개") );
    }

    private static void printBenefit(int benefit) {
        System.out.println("수익률은" + benefit + "% 입니다");
    }
}

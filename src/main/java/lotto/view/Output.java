package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.enums.LottoCorrectCount;
import lotto.util.LottoUtils;

import java.util.List;
import java.util.Map;

import static java.util.Optional.ofNullable;
import static lotto.domain.enums.LottoCorrectCount.*;

public class Output {
    private static final String UI_FORMAT = "[%s]";

    public static void print(String value) {
        System.out.println(value);
    }

    public static String lottoNumbersFormatting(int[] numbers) {
        return String.format(UI_FORMAT, String.join(LottoUtils.REGEX, LottoUtils.convertIntToString(numbers)));
    }

    public static void printResult(Map<LottoCorrectCount, Integer> resultMap) {
        print("");
        print("당첨 통계");
        print("----------");
        print(String.format("3개 일치(5000원) - %d개", ofNullable(resultMap.get(THREE)).orElse(0)));
        print(String.format("4개 일치(50000원) - %d개", ofNullable(resultMap.get(FOUR)).orElse(0)));
        print(String.format("5개 일치(1500000원) - %d개", ofNullable(resultMap.get(FIVE)).orElse(0)));
        print(String.format("6개 일치(2000000000원) - %d개", ofNullable(resultMap.get(SIX)).orElse(0)));
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> print(lottoNumbersFormatting(lotto.getNumbers())));
    }

    public static void printLottoCount(int count) {
        print(String.format("%d개를 구매했습니다.", count));
    }

    public static void printProfit(Map<LottoCorrectCount, Integer> resultMap, int money) {
        print(String.format("총 수익률은 %f%%입니다.", LottoUtils.getProfitRate(LottoUtils.getProfit(resultMap), money)));
    }

}

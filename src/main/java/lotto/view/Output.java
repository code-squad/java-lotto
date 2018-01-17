package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoMachine;
import lotto.domain.LottoResult;
import lotto.domain.enums.Rank;
import lotto.util.LottoUtils;

import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;
import static lotto.domain.LottoResult.getProfit;
import static lotto.domain.LottoResult.getProfitRate;

public class Output {
    private static final String UI_FORMAT = "[%s]";

    public static void print(String value) {
        System.out.println(value);
    }

    public static String lottoNumbersFormatting(List<Integer> numbers) {
        return String.format(UI_FORMAT, String.join(LottoUtils.REGEX, LottoUtils.convertIntToString(numbers)));
    }

    public static void printResult(LottoResult lottoResult, int money) {
        print("");
        print("당첨 통계");
        print("----------");
        winningLottoprintLoop(lottoResult);
        print(String.format("총 수익률은 %f%%입니다.", getProfitRate(getProfit(lottoResult.getWinningLottoMap()), money)));
    }

    private static void winningLottoprintLoop(LottoResult lottoResult) {
        Arrays.stream(Rank.values())
                .forEach(count -> print(String.format("%d개 일치(%d원) - %d개",
                                count.getValue(),
                                count.getProfit(),
                                ofNullable(lottoResult.getWinningLottoMap().get(count)).orElse(0))));
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.stream().forEach(lotto -> print(lottoNumbersFormatting(lotto.getNumbers())));
    }

    public static void printLottoCount(LottoMachine lottoMachine) {
        print(String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", lottoMachine.getCustomLottoCount(), lottoMachine.getRandomLottoCount()));
    }

}

package lotto.view;

import lotto.Prize;

import java.util.List;
import java.util.Map;

public class DefaultOutputView implements OutputView {

    private static final String PURCASED_COUNT_FORMAT = "%s개를 구매했습니다.";
    private static final String WIN_STATISTICS_FORMAT = "당첨 통계\n---------";
    private static final String THREE_WIN_FORMAT = "3개 일치 (5000원) - %s개";
    private static final String FOUR_WIN_FORMAT = "4개 일치 (50000원) - %s개";
    private static final String FIVE_WIN_FORMAT = "5개 일치 (1500000원) - %s개";
    private static final String SIX_WIN_FORMAT = "6개 일치 (2000000000) - %s개";
    private static final String EARNING_RATE_FORMAT = "총 수익률은 %s%%입니다.";

    private List<LottoViewDto> lottoViewDtos;

    public DefaultOutputView(List<LottoViewDto> lottoViewDtos) {
        this.lottoViewDtos = lottoViewDtos;
    }

    @Override
    public void printPurchasedLotto() {
        println(PURCASED_COUNT_FORMAT, this.lottoViewDtos.size());
        printPurchasedLottoResult();
        newLine();
    }

    @Override
    public void printLottoResult(Map<Prize, Integer> result, int calculateEarningRate) {
        newLine();
        println(WIN_STATISTICS_FORMAT);
        println(THREE_WIN_FORMAT, result.get(Prize.FOURTH));
        println(FOUR_WIN_FORMAT, result.get(Prize.THIRD));
        println(FIVE_WIN_FORMAT, result.get(Prize.SECOND));
        println(SIX_WIN_FORMAT, result.get(Prize.FIRST));
        println(EARNING_RATE_FORMAT, calculateEarningRate);
    }

    private void printPurchasedLottoResult() {
        this.lottoViewDtos.forEach(lotto -> println(lotto.getLottos().toString()));
    }

    private static void println(String input, long result) {
        System.out.println(String.format(input, result));
    }

    private static void println(String input) {
        System.out.println(input);
    }

    private static void newLine() {
        System.out.println();
    }
}

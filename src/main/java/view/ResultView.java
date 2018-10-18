package view;

import utils.LottoPrize;
import dto.LottoDto;
import dto.ResultDto;

import java.util.List;

import static utils.LottoGameValue.PRIZE_MATCH_MAX;
import static utils.LottoGameValue.PRIZE_MATCH_MIN;

public class ResultView {
    public static final String NEWLINE = System.getProperty("line.separator");

    private ResultView() {
    }

    public static void showTicketAmount(int lottoTicketNum) {
        System.out.println(lottoTicketNum + "개를 구매했습니다.");
    }

    public static void showLottos(LottoDto lottoDto) {
        for (List<Integer> lotto : lottoDto.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void showResult(ResultDto resultDto) {
        System.out.println(NEWLINE + "당첨 통계" + NEWLINE + "---------");
        for (int i = PRIZE_MATCH_MIN; i <= PRIZE_MATCH_MAX; i++) {
            System.out.println(i + "개 일치 (" + LottoPrize.getLottoPrize(i) + ")원- " + resultDto.getMatchResult().get(i));
        }
        System.out.println("총 수익률은 " + resultDto.getProfitRate() + "%입니다.");
    }
}

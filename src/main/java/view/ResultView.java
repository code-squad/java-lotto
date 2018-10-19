package view;

import utils.LottoPrizeMapper;
import dto.LottoDto;
import dto.ResultDto;

import java.util.List;

import static utils.LottoGameValues.PRIZE_STRIKE_MAX;
import static utils.LottoGameValues.PRIZE_STRIKE_MIN;

public class ResultView {
    static final String NEWLINE = System.getProperty("line.separator");

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

    public static void showLottoResult(ResultDto resultDto) {
        System.out.println(NEWLINE + "당첨 통계" + NEWLINE + "---------");
        for (int i = PRIZE_STRIKE_MIN; i <= PRIZE_STRIKE_MAX; i++) {
            System.out.println(i + "개 일치 (" + LottoPrizeMapper.get(i) + ")원- " + resultDto.getStrikeResults().get(i));
        }
        System.out.println("총 수익률은 " + resultDto.getProfitRate() + "%입니다.");
    }
}

package view;

import domain.Lotto;
import utils.Rank;
import dto.LottoDto;
import dto.ResultDto;

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
        for (Lotto lotto : lottoDto.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void showLottoResult(ResultDto resultDto) {
        for (Rank value : Rank.values()) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getCountOfStrike() + "개 일치");
            if(value.equals(Rank.SECOND)) {
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (" + value.getWinningMoney() + "원) ");
            sb.append("- " + resultDto.getGameResults().get(value) + "개");
            System.out.println(sb.toString());
        }
        System.out.printf("총 수익률은 %d%%입니다." + NEWLINE, resultDto.getProfitRate());
    }
}

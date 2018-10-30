package view;

import domain.Lotto;
import utils.Rank;
import dto.LottoDto;
import dto.ResultDto;

public class ResultView {
    public static final String NEWLINE = System.getProperty("line.separator");

    private ResultView() {
    }

    public static void requestManualLottoNum() {
        System.out.println(NEWLINE + "수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printKindsOfLottosCount(int lottoTicketCount, int manualLottoCount) {
        System.out.printf(NEWLINE + "수동으로 %d장, 자동으로 %d개를 구매했습니다." + NEWLINE, manualLottoCount, lottoTicketCount - manualLottoCount);
    }

    public static void showLottos(LottoDto lottoDto) {
        for (Lotto lotto : lottoDto.getLottos()) {
            System.out.println(lotto);
        }
    }

    public static void showLottoResult(ResultDto resultDto) {
        System.out.print(NEWLINE);
        System.out.print("당첨 통계" + NEWLINE + "---------" + NEWLINE);
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

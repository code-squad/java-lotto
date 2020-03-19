package view;

import vo.Rank;
import dto.StatisticsDto;
import dto.LottoDto;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String NUM_OF_PERCHASE_LOTTO_MSG = "수동으로 %d장, 자동으로 %d개를 구매했습니다";
    private static final String STATISTICS_OF_RESULT_MSG = "당첨통계";
    private static final String DIVISION_LINE = "---------";
    private static final String EACH_RANK_MATCHING_NUM_MSG = "%d개 일치 %s(%d원)- %d개\n";
    private static final String BONUS_BALL_MATCH_MSG = "보너스 볼 일치";
    private static final String TOTAL_RATE_OF_RETURN_MSG = "총 수익률은 %d%%입니다.";

    public static void printPurchaseLottoSize(int manualLottoSize, int autoLottoSize) {
        System.out.println();
        System.out.printf(NUM_OF_PERCHASE_LOTTO_MSG, manualLottoSize, autoLottoSize);
    }

    public static void printPurchaseLottos(List<LottoDto> lottoDtos) {
        System.out.println();
        for (LottoDto lottoDto : lottoDtos) {
            System.out.println(lottoDto.getNumbers());
        }
    }

    public static void printMatchingResult(StatisticsDto statisticsDto) {
        System.out.println();
        System.out.println(STATISTICS_OF_RESULT_MSG);
        System.out.println(DIVISION_LINE);

        Map<Rank, Integer> rankCount = statisticsDto.getRankCount();
        Rank[] rank = Rank.values();
        for (int i = rank.length - 2; i >= 0; i--) {
            System.out.printf(EACH_RANK_MATCHING_NUM_MSG,
                    rank[i].getCountOfMatch(),
                    (i == 1) ? BONUS_BALL_MATCH_MSG : "",
                    rank[i].getWinningMoney(),
                    rankCount.getOrDefault(rank[i], 0)
            );
        }
    }

    public static void printTotalRateOfReturn(int totalRateOfReturn) {
        System.out.printf(TOTAL_RATE_OF_RETURN_MSG, totalRateOfReturn);
    }
}

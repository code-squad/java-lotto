package view;

import domain.Rank;
import dto.AnalyzeDto;
import dto.LottoDto;
import dto.LottoPurchaseInfoDto;

import java.util.Map;

public class OutputView {
    private static final String NUM_OF_PERCHASE_LOTTO_MSG = " 개를 구매했습니다";
    private static final String STATISTICS_OF_RESULT_MSG = "당첨통계";
    private static final String DIVISION_LINE = "---------";
    private static final String EACH_RANK_MATCHING_NUM_MSG = "%d개 일치 (%d원)- %d개\n";
    private static final String TOTAL_RATE_OF_RETURN_MSG = "총 수익률은 %d%%입니다.";

    public static void printPurchaseLottoSize(int lottosDtoSize) {
        System.out.println(lottosDtoSize + NUM_OF_PERCHASE_LOTTO_MSG);
    }

    public static void printPurchaseLottos(LottoPurchaseInfoDto lottoPurchaseInfoDto) {
        for (LottoDto lottoDto : lottoPurchaseInfoDto.getLottos()) {
            System.out.println(lottoDto.getNumbers());
        }
    }

    public static void printMatchingResult(AnalyzeDto analyzeDto) {
        System.out.println();
        System.out.println(STATISTICS_OF_RESULT_MSG);
        System.out.println(DIVISION_LINE);

        Map<Rank, Integer> rankCount = analyzeDto.getRankCount();
        Rank[] rank = Rank.values();
        for (int i = rank.length - 2; i >= 0; i--) {
            System.out.printf(EACH_RANK_MATCHING_NUM_MSG,
                    rank[i].getCountOfMatch(),
                    rank[i].getWinningMoney(),
                    rankCount.getOrDefault(rank[i], 0)
            );
        }
    }

    public static void printTotalRateOfReturn(int totalRateOfReturn) {
        System.out.printf(TOTAL_RATE_OF_RETURN_MSG, totalRateOfReturn);
    }
}

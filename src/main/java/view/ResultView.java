package view;

import vo.Rank;
import dto.LottoDto;
import dto.LottoDtos;
import dto.WinResultDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottos(LottoDtos lottoDtos, int lottoManualAmt) {
        List<LottoDto> result = lottoDtos.getLottoDtos();

        System.out.println("수동으로 " + lottoManualAmt + "장, 자동으로 " + (result.size() - lottoManualAmt) + "개를 구매했습니다.");
        for (LottoDto lottoDto : result) {
            System.out.println(lottoDto);
        }
        System.out.println();
    }

    public static void winStats(WinResultDto result) {
        System.out.println("\n당첨통계\n-------");

        printMatchRank(result.getWinResultDto());
    }

    public static void printMatchRank(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            System.out.println(
                    rank.getMatchNumAmt() + "개 일치" + printRankSecond(rank) +
                            rank.getReward() + "원) - " +
                            result.get(rank) + "개"
            );
        }
    }

    private static String printRankSecond(Rank rank) {
        if(rank.equals(Rank.SECOND))
            return ", 보너스 볼 일치(";
        return " (";
    }

    public static void printYield(int yield) {
        System.out.println("총 수익률은 " + yield +"%입니다.");
    }

}

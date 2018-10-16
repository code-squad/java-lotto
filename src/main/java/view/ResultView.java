package view;

import domain.Rank;
import dto.LottoDto;
import dto.LottoDtos;
import dto.WinResultDto;

import java.util.List;
import java.util.Map;

public class ResultView {

    public static void printLottos(LottoDtos lottoDtos) {
        for (LottoDto lottoDto : lottoDtos.getLottoDtos()) {
            System.out.println(lottoDto);
        }
        System.out.println();
    }

    public static void winStats(WinResultDto result, int purchaseAmt) {
        System.out.println("\n당첨통계\n-------");

        printMatchRank(result.getWinResultDto());
        printYield(result, purchaseAmt);
    }

    public static void printMatchRank(Map<Rank, Integer> result) {
        for (Rank rank : Rank.values()) {
            System.out.println(
                    rank.getMatchNumAmt() + "개 일치 (" +
                            rank.getReward() + "원)- " +
                            result.get(rank) + "개"
            );
        }
    }

    public static void printYield(WinResultDto result, int purchaseAmt) {
        System.out.println("총 수익률은 " + result.getYield(purchaseAmt) +"%입니다.");
    }

}

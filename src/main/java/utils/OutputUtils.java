package utils;

import domain.result.LottoResults;
import domain.result.Rank;

import java.util.ArrayList;
import java.util.List;

public class OutputUtils {
    public static List<String> buildRankMessage(LottoResults results) {
        Rank[] ranks = Rank.values();
        ArrayList<String> resultMessages = new ArrayList<>();
        for (Rank rank : ranks) {
            resultMessages.add(doBuild(rank, results));
        }
        return resultMessages;
    }

    private static String doBuild(Rank rank, LottoResults results) {
        return rank.getMatchPoint() + "개 일치 (" + rank.getPrize() + "원) - " + results.calcRankNum(rank) + "개";
    }
}

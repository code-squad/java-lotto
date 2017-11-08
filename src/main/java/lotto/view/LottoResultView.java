package lotto.view;

import lotto.model.MatchingResults;
import lotto.model.MatchingResults.Match;
import lotto.model.MatchingResults.MatchingResult;

public class LottoResultView {
    public static final String NEWLINE = System.getProperty("line.separator");
    public static final String LOTTO_REPORT_HEADER = "당첨 통계" + NEWLINE + "----" + NEWLINE;
    public static final String LOTTO_REPORT_FOOTER = "총 수익률은 %d 입니다.";
    
    public static void show(MatchingResults result) {
        StringBuilder sb = new StringBuilder(LOTTO_REPORT_HEADER);
        
        Iterable<MatchingResult> matchingResults = result.getResults();
        for (MatchingResult matchingResult : matchingResults) {
            appendByMatch(sb, matchingResult.getCountOfMatch(), matchingResult.getCountOfMatchingLotto());
        }
        sb.append("총 수익률은 ");
        sb.append(result.getProfit());
        sb.append("%입니다.");
        
        System.out.println(sb.toString());
    }

    private static void appendByMatch(StringBuilder sb, int countOfMatch, int noOfMatch) {
        sb.append(countOfMatch);
        sb.append("개 일치 (");
        sb.append(Match.valueOf(countOfMatch).getWinningMoney());
        sb.append(") - ");
        sb.append(noOfMatch);
        sb.append("개");
        sb.append(NEWLINE);
    }
}

package view;

import dto.LottoBundleDto;
import dto.LottoDto;
import dto.WinStatsDto;
import vo.Rank;

public class ResultView {
    private static final String ECHO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER = System.lineSeparator();
    private static final String EARNING_RATE_MESSAGE = "당첨 통계";
    private static final String HYPHENS = "---------";
    private static final String HIT_COUNT_MESSAGE = "개 일치 ";
    private static final String COUNT_MESSAGE = "개";
    private static final String PERCENT = "%";

    private static StringBuilder sb = new StringBuilder();


    public static void echoCount(int count){
        System.out.println(count + ECHO_COUNT_MESSAGE);
    }

    public static void showLottoBundles(LottoBundleDto lottoBundles) {
        System.out.println(makeLottoBundlesMessage(lottoBundles));
    }
    private static String makeLottoBundlesMessage(LottoBundleDto lottoBundles){
        sb.setLength(0);
        for (LottoDto theLottoDto : lottoBundles.getTheBundle()) {
            sb.append(theLottoDto.toString() + ENTER);
        }
        return sb.toString();
    }

    public static void showResultMessage(WinStatsDto theWinStatsDto){
        System.out.println(ENTER + EARNING_RATE_MESSAGE + ENTER + HYPHENS);
        System.out.println(makeRankMessages(theWinStatsDto));
        System.out.println("총 수익률은 " + String.format("%.1f", theWinStatsDto.getEarningRate()) + PERCENT + "입니다.");
    }

    private static String makeRankMessages(WinStatsDto theWinStatsDto){
        sb.setLength(0);
        for(Rank rank : Rank.values()){
            sb.append(rank.getMatchCount() + HIT_COUNT_MESSAGE + "(" + rank.getReward() + ")- "
                    + theWinStatsDto.getNumberOfCounts(rank) + COUNT_MESSAGE);
            sb.append(ENTER);
        }
        return sb.toString();
    }
}

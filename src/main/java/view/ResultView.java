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
    private static final String COMMA = ", ";
    private static final String MANUAL = "수동으로 ";
    private static final String AUTO = "자동으로 ";

    private static StringBuilder sb = new StringBuilder();

    public static void echoCount(int manualCount, int autoCount){
        System.out.print(MANUAL + manualCount + COUNT_MESSAGE + COMMA);
        System.out.println(AUTO + autoCount + ECHO_COUNT_MESSAGE);
    }

    public static void showLottoBundles(LottoBundleDto lottoBundles) {
        System.out.println(makeLottoBundlesMessage(lottoBundles));
    }

    private static String makeLottoBundlesMessage(LottoBundleDto lottoBundles){
        sb.setLength(0);
        for (LottoDto theLottoDto : lottoBundles.getTheBundle()) {
            sb.append(theLottoDto.toString());
            sb.append(ENTER);
        }
        return sb.toString();
    }

    public static void showResultMessage(WinStatsDto theWinStatsDto){
        System.out.println(ENTER + EARNING_RATE_MESSAGE + ENTER + HYPHENS);
        System.out.println(makeWinStatsMessage(theWinStatsDto));
        System.out.println("총 수익률은 " + String.format("%.1f", theWinStatsDto.getEarningRate()) + PERCENT + "입니다.");
    }

    private static String makeWinStatsMessage(WinStatsDto theWinStatsDto){
        sb.setLength(0);
        for(Rank rank : Rank.values()){
            makeRankMessage(rank);
            sb.append(theWinStatsDto.getNumberOfCounts(rank));
            sb.append(COUNT_MESSAGE);
            sb.append(ENTER);
        }
        return sb.toString();
    }

    private static void makeRankMessage(Rank rank) {
        sb.append(rank.getMatchCount());
        sb.append(HIT_COUNT_MESSAGE);
        sb.append("(");
        sb.append(rank.getReward());
        sb.append("원");
        sb.append(") - ");
    }
}

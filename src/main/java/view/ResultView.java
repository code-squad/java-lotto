package view;

import dto.LottoBundleDto;
import dto.LottoDto;
import dto.ResultDto;

public class ResultView {
    private static final String ECHO_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String ENTER = System.lineSeparator();
    private static final String COUNT = "개";
    private static final String EARNING_RATE_MESSAGE = "당첨 통계";
    private static final String HYPHENS = "---------";
    private static final String THREE_HIT_MESSAGE = "3개 일치 (5000원)- ";
    private static final String FOUR_HIT_MESSAGE = "4개 일치 (50000원)- ";
    private static final String FIVE_HIT_MESSAGE = "5개 일치 (1500000원)- ";
    private static final String SIX_HIT_MESSAGE = "6개 일치 (2000000000원)- ";
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

    public static void showEarningRate(ResultDto theResultDto) {
        System.out.println(ENTER + EARNING_RATE_MESSAGE + ENTER + HYPHENS);
        System.out.println(makeEarningRateMessage(theResultDto.getWinStats()));
        System.out.println(makeEarningRate(theResultDto.getWinStats(), theResultDto.getTheLottoBundleDtoSize()) + PERCENT);
    }

    private static String makeEarningRateMessage(int[] generateWinStats){
        sb.setLength(0);
        sb.append(THREE_HIT_MESSAGE);
        sb.append(generateWinStats[3] + COUNT + ENTER);
        sb.append(FOUR_HIT_MESSAGE);
        sb.append(generateWinStats[4] + COUNT + ENTER);
        sb.append(FIVE_HIT_MESSAGE);
        sb.append(generateWinStats[5] + COUNT + ENTER);
        sb.append(SIX_HIT_MESSAGE);
        sb.append(generateWinStats[6] + COUNT + ENTER);
        return sb.toString();
    }

    private static String makeEarningRate(int[] generateWinStats, int count){
        double earnMoney = 0;
        double investedMoney =  count  * 1000;
        earnMoney += generateWinStats[3] * 5000;
        earnMoney += generateWinStats[4] * 50000;
        earnMoney += generateWinStats[5] * 1500000;
        earnMoney += generateWinStats[6] * 2000000000;
        return String.format("%.1f", (earnMoney / investedMoney) * 100);
    }
}

package domain;

public class LottoResult {
    private static int first;
    private static int second;
    private static int third;
    private static int fourth;
    private static int fifth;
    private static int rateOfProfit;

    public static void calcRateOfProfit(int purchaseFee) {
        rateOfProfit =  (((5000 * fourth) + (50000 * third) + (1500000 * second) + (2000000000 * first)) * 100) / purchaseFee;
    }

    public static boolean isValid(int matchedCount) {
        // 3보다 작으면 return false 를 제일 먼저 체크하기.
        if (matchedCount == 3) {
            fourth++;
            return true;
        }
        if (matchedCount == 4) {
            third++;
            return true;
        }
        if (matchedCount == 5) {
            second++;
            return true;
        }
        if (matchedCount == 6) {
            first++;
            return true;
        }
        return false;
    }

    public static String printResult() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨통계\n");
        sb.append("---------\n");
        sb.append("3개 일치 (5000원)-" + fourth + "개\n");
        sb.append("4개 일치 (50000원)-" + third + "개\n");
        sb.append("5개 일치 (1500000원)-" + second + "개\n");
        sb.append("6개 일치 (2000000000원)-" + first + "개\n");
        sb.append("총 수익률은 " + rateOfProfit + "%입니다.\n");
        return sb.toString();
    }
}

package View;

import domain.Result;

public class ResultView {
    public static void printAutoManualCount(int total, int manual) {
        int auto = total - manual;
        System.out.println("수동으로 " + manual + "장, 자동으로 " + auto + "개를 구매했습니다.");
    }

    public static void printResult(Result result) {
        System.out.println(result.toString());
    }
}

package Lotto;

import java.util.Arrays;

public class OutputLottoView {

    public static void numberOfLottoPurchase(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static String lottoNumberPrint(Integer[] lottoNumber) {
        return makeLottoNumberFormat(changeLottoNumberType(lottoNumber));
    }

    private static String makeLottoNumberFormat(String[] lottoNumber) {
        return Arrays.toString(lottoNumber);
    }

    private static String[] changeLottoNumberType(Integer[] lottoNumber) {
        String[] returnLottoNumber = new String[7];

        for (int i = 0; i < returnLottoNumber.length; i++) {
            returnLottoNumber[i] = String.valueOf(lottoNumber[i]);
        }

        return returnLottoNumber;
    }

    public static void winStat(Lotto lotto) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        System.out.println("3개 일치 (5000원)- " + lotto.getThreeMatchCount() + "개");
        System.out.println("4개 일치 (50000원)- " + lotto.getFourMatchCount() + "개");
        System.out.println("5개 일치 (1500000원)- " + lotto.getFiveMatchCount() + "개");
        System.out.println("6개 일치 (2000000000원)- " + lotto.getSixMatchCount() + "개");
        System.out.println("총 수익률은 " + lotto.getYield() + "%입니다.");
    }
}
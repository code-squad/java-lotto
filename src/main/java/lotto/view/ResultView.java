package lotto.view;

import lotto.LottoMain;
import lotto.dto.LottoDto;
import lotto.dto.LottoManagerDto;

public class ResultView {
    private static final int SAME_THREE = 5000;
    private static final int SAME_FOUR = 50000;
    private static final int SAME_FIVE = 1500000;
    private static final int SAME_SIX = 2000000000;

    public static void winList(int myMoney){
        int result = ((SAME_THREE * LottoMain.map.get(3)) + (SAME_FOUR * LottoMain.map.get(4)) +
                (SAME_FIVE * LottoMain.map.get(5)) + (SAME_SIX * LottoMain.map.get(6))) / myMoney * 100;

        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (" + SAME_THREE + "원)- " + LottoMain.map.get(3) + "개");
        System.out.println("4개 일치 (" + SAME_FOUR + "원)- " + LottoMain.map.get(4) + "개");
        System.out.println("5개 일치 (" + SAME_FIVE + "원)- " + LottoMain.map.get(5) + "개");
        System.out.println("6개 일치 (" + SAME_SIX + "원)- " + LottoMain.map.get(6) + "개");
        System.out.println("총 수익률은 " + result + "%입니다.");
    }

    public static void printLotto(LottoManagerDto lottoManagerDto){
        System.out.println(lottoManagerDto.getLottoManagerSize() + "개를 구매했습니다.");
        for (LottoDto lotto : lottoManagerDto.getLottoManagerDto()) {
            System.out.println(lotto);
        }
    }

}

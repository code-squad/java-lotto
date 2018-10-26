package lotto.view;

import lotto.domain.LottoManager;

public class ResultView {
    public static final int SAME_THREE = 5000;
    public static final int SAME_FOUR = 50000;
    public static final int SAME_FIVE = 1500000;
    public static final int SAME_SIX = 2000000000;

    public static void winList(LottoManager lottoManager) {
        System.out.println("당첨 통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (" + SAME_THREE + "원)- " + lottoManager.sameThree() + "개");
        System.out.println("4개 일치 (" + SAME_FOUR + "원)- " + lottoManager.sameFour() + "개");
        System.out.println("5개 일치 (" + SAME_FIVE + "원)- " + lottoManager.sameFive() + "개");
        System.out.println("6개 일치 (" + SAME_SIX + "원)- " + lottoManager.sameSix() + "개");
        System.out.println("총 수익률은 " + lottoManager.yield() + "%입니다.");
    }

    public static void printLotto(LottoManager lottoManager) {
        System.out.println(lottoManager.getSize() + "개를 구매했습니다.");
        for (int i = 0; i < lottoManager.getSize(); i++) {
            System.out.println(lottoManager.getLotto(i));
        }
    }
}

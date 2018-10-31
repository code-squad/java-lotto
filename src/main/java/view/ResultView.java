package view;

import vo.Prize;
import dto.LottoDto;
import dto.LottosDto;

import java.util.Map;

public class ResultView {
    static final int PERCENTAGE = 100;

    public static void printLottos(LottosDto lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (LottoDto lottoDto : lottos.getLottos()) {
            System.out.println(lottoDto.toString());
        }
    }

    public static void printResult(Map<Prize, Integer> resultInfo, int purchasePrice) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (Prize prize : resultInfo.keySet()) {
            System.out.println(prize.getNumber() + "개 일치 (" + prize.getMoney() + "원)-" + resultInfo.get(prize) + "개");
        }
        System.out.println("총 수익률은 " + calculateProfitRate(resultInfo, purchasePrice) + "%입니다");
    }

    private static int calculateProfitRate(Map<Prize, Integer> resultInfo, int purchasePrice) {
        int sum = 0;
        for (Prize prize : resultInfo.keySet()) {
            sum += prize.getMoney() * resultInfo.get(prize);
        }
        return sum * PERCENTAGE / purchasePrice;
    }
}

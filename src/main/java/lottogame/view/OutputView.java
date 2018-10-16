package lottogame.view;

import lottogame.domain.Lotto;
import lottogame.domain.PrizeRank;
import lottogame.dto.ResultDTO;

import java.util.stream.Stream;

public class OutputView {
    public static void printLottoAmount(int countLotto) {
        System.out.println(countLotto + "개를 구입했습니다.");
    }

    public static void printLotto(Stream<Lotto> readLotto) {
        readLotto.map(Lotto::toString).forEach(System.out::println);
    }

    public static void printResult(int inputMoney, ResultDTO resultDTO) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        int priceMoney = 0;
        PrizeRank[] values = PrizeRank.values();
        for (int i = 0; i < values.length - 1; i++) {   //BOOM은 출력하지 않는다.
            System.out.println(values[i].getHitAmount() + "개 일치 ( "
                    + values[i].getRewardMoney() + ")원 "
                    + resultDTO.getHitCountOf(values[i]) + "개");
            priceMoney += values[i].getRewardMoney() * resultDTO.getHitCountOf(values[i]);
        }
        System.out.println("총 수익률은 " + priceMoney / inputMoney * 100 + "% 입니다.");
    }
}

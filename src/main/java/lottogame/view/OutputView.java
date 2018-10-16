package lottogame.view;

import lottogame.domain.Lotto;
import lottogame.domain.PrizeRank;
import lottogame.vo.ResultVO;

import java.util.stream.Stream;

public class OutputView {
    public static void printLottoAmount(int countLotto) {
        System.out.println(countLotto + "개를 구입했습니다.");
    }

    public static void printLotto(Stream<Lotto> readLotto) {
        readLotto.map(Lotto::toString).forEach(System.out::println);
    }

    public static void printResult(int inputMoney, ResultVO resultVO) {
        System.out.println("당첨 통계");
        System.out.println("--------------------------");
        int priceMoney = 0;
        for (PrizeRank value : PrizeRank.values()) {
            System.out.println(value.getHitAmount() + "개 일치 ( "
                    + value.getRewardMoney() + ")원 "
                    + resultVO.hitCountOf(value) + "개");
            priceMoney += value.getRewardMoney() * resultVO.hitCountOf(value);
        }
        System.out.println("총 수익률은 " + priceMoney / inputMoney * 100 + "% 입니다.");
    }
}

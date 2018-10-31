package view;

import dto.LottoDto;
import dto.UserLottoDto;
import lotto.Rank;
import lotto.Reward;
import util.Utility;

import java.util.Map;

public class PrintView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printResult(Map<Rank, Integer> reward, int sumPurchasingPrice) {
        for (Rank rank : Rank.values()) {
            System.out.println(rank.getCountOfMatch() + "개 일치 " + rank.getWinningMoney() + "- " + reward.get(rank) + "개");
        }
        System.out.println("총 수익률은 " + Utility.multiplyHundred(new Reward().earningRate(reward) / sumPurchasingPrice) + "%");
    }

    public static void printAutoLotto(UserLottoDto userLottoDto) {
        for (LottoDto lottoDto : userLottoDto.getUserLottoDto()) {
            System.out.println(lottoDto);
        }
    }

}

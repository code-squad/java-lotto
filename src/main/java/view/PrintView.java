package view;

import dto.LottoDto;
import dto.UserLottoDto;
import lotto.Reward;
import util.Utility;

import java.util.HashMap;
import java.util.Map;

public class PrintView {
    public static void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public static void printResult(Map<Integer, Integer> map, int sumPurchasingPrice) {
        Reward reward = new Reward();
        for (Integer integer : map.keySet()) {
            System.out.println(integer + "개 일치 " + reward.lottoPrice().get(integer) + "- " + map.get(integer) + "개");
        }
        System.out.println("총 수익률은 " + Utility.multiplyHundred(reward.earningRate(map) / sumPurchasingPrice) + "%");
    }

    public static void printAutoLotto(UserLottoDto userLottoDto) {
        for (LottoDto lottoDto : userLottoDto.getUserLottoDto()) {
            System.out.println(lottoDto);
        }
    }

}

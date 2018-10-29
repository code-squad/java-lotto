package util;

import domain.Lotto;
import domain.LottoFactory;
import domain.Reward;
import dto.RewardDto;

public class StringFormat {
    public static String lottoFormat(String input) {
        return "[" + input + "]";
    }

    public static String lottoNumFormat(int num, int index) {
        if(index == Lotto.LOTTO_NUMBER_COUNT - 1) {
            return num + "";
        }
        return num + LottoFactory.SPLIT_STANDARD;
    }

    public static String winStatsFormat(Reward reward, int matchCount) {
        if(reward.isSecond()) {
            return String.format("%d개 일치, 보너스볼 일치 (%d원) - %d개", reward.obtainLottoHit(), reward.obtainPrize(), matchCount);
        }
        return String.format("%d개 일치 (%d원) - %d개", reward.obtainLottoHit(), reward.obtainPrize(), matchCount);
    }

    public static void showProfit(RewardDto rewardDto) {
        System.out.println(profitFormat(rewardDto.getProfit()));
    }

    public static String profitFormat(int profit) {
        return String.format("총 수익률은 %d%%입니다.", profit);
    }

    public static String purchaseFormat(int handOperated, int auto) {
        return String.format("수동으로 %d장, 자동으로 %d개를 구매했습니다.", handOperated, auto);
    }
}

package util;

import domaim.Lotto;
import domaim.LottoFactory;
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

    public static String winStatsFormat(int count, int price, int matchCount) {
        return String.format("%d개 일치 (%d원) - %d개", count, price, matchCount);
    }

    public static void showProfit(RewardDto rewardDto) {
        System.out.println(profitFormat(rewardDto.getProfit()));
    }

    public static String profitFormat(int profit) {
        return String.format("총 수익률은 %d%%입니다.", profit);
    }
}

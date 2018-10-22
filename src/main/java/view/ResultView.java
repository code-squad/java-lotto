package view;

import domain.Lotto;
import dto.LottoDto;
import dto.RewardDto;
import util.StringFormat;

import java.util.Iterator;

public class ResultView {
    public static void showLottoList(LottoDto lottoDto) {
        for(Lotto lotto : lottoDto.getLottos()) {
            showLotto(lotto);
        }
    }

    private static void showLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            sb.append(StringFormat.lottoNumFormat(lotto.getLottoNum(i).getNo(), i));
        }
        System.out.println(StringFormat.lottoFormat(sb.toString()));
    }

    public static void showLottoNum(LottoDto lottoDto) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoDto.getLottos().size()));
    }

    public static void showWinStats(RewardDto rewardDto) {
        Iterator<Integer> it = rewardDto.getRewardMapper().keySet().iterator();
        while(it.hasNext()) {
            int count = it.next();
            System.out.println(StringFormat.winStatsFormat(count, rewardDto.getRewardMapper().get(count), rewardDto.getRewardResult().get(count)));
        }
    }

    public static void showProfit(RewardDto rewardDto) {
        System.out.println(StringFormat.profitFormat(rewardDto.getProfit()));
    }
}

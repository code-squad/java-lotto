package domain;

import dto.StatisticDto;
import vo.Prize;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistic {
    private final int MIN = 3;

    private List<Lotto> lottos;
    private Map<Prize, Integer> winnerInfo = new LinkedHashMap<>();

    public Statistic(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    private void initWinnerInfo() {
        winnerInfo.put(Prize.THREE, 0);
        winnerInfo.put(Prize.FOUR, 0);
        winnerInfo.put(Prize.FIVE, 0);
        winnerInfo.put(Prize.SIX, 0);
    }

    private void plusPrizeNumber(int cnt) {
        for (Prize prize : winnerInfo.keySet()) {
            if (prize.getNumber() == cnt) {
                winnerInfo.put(prize, winnerInfo.get(prize) + 1);
            }
        }
    }

    public void checkLottoRank(Lotto winnerLotto) {
        initWinnerInfo();
        for (Lotto lotto : lottos) {
            int cnt = lotto.checkRank(winnerLotto);     //당첨번호 일치 개수
            if (cnt >= MIN) {
                plusPrizeNumber(cnt);
            }
        }
    }

    public StatisticDto toDto() {
        return new StatisticDto(this.winnerInfo);
    }
}

package domain;

import spark.utils.CollectionUtils;

import java.util.List;

import static common.Constant.LOTTO_PRICE;

public class WinningLottos {

    private final List<WinningLotto> winningLottos;

    public WinningLottos(List<WinningLotto> winningLottos) {
        if (CollectionUtils.isEmpty(winningLottos)) {
            throw new IllegalArgumentException();
        }
        this.winningLottos = winningLottos;
    }

    public double getRevenue() {
        return getBenefit() / (double) getInvestment() * 100;
    }

    private int getInvestment() {
        return winningLottos.size() * LOTTO_PRICE;
    }

    public double getBenefit() {
        return winningLottos.stream()
                            .mapToInt(WinningLotto::getWinningMoney)
                            .sum();
    }

    public int getCountOfRank(Rank rank) {
        return (int) winningLottos.stream()
                                  .filter(r -> r.getRank() == rank)
                                  .count();
    }
}

package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;

import java.util.ArrayList;
import java.util.List;

public class RankUtil {
    public List<Integer> pageMoney(List<Lotto> lottos, List<Integer> prize){
        List<Integer> pageMoney = new ArrayList<>();
        pageMoney.add(rackFifth(lottos, prize));
        pageMoney.add(rackFourth(lottos, prize));
        pageMoney.add(rackThird(lottos, prize));
        pageMoney.add(rackFirst(lottos, prize));
        return pageMoney;
    }

    public double amount(List<Integer> pageMoney, int input){
        Money money = new Money(pageMoney);
        List<Rank> ranks = LottoUtil.ranks();
        return money.profitRate(ranks, input);
    }

    public int rackFifth(List<Lotto> lottos, List<Integer> prize) {
        int fifth = 0;
        for (Lotto lotto : lottos) {
            if (lotto.matchNum(prize) == Rank.FIFTH.getCountOfMatch()) {
                fifth++;
            }
        }
        return fifth;
    }

    public int rackFourth(List<Lotto> lottos, List<Integer> prize) {
        int fourth = 0;
        for (Lotto lotto : lottos) {
            if (lotto.matchNum(prize) == Rank.FOURTH.getCountOfMatch()) {
                fourth++;
            }
        }
        return fourth;
    }


    public int rackThird(List<Lotto> lottos, List<Integer> prize) {
        int third = 0;
        for (Lotto lotto : lottos) {
            if (lotto.matchNum(prize) == Rank.THIRD.getCountOfMatch()) {
                third++;
            }
        }
        return third;
    }

    public int rackSecond(List<Lotto> lottos, List<Integer> prize) {
        int second = 0;
        for (Lotto lotto : lottos) {
            if (lotto.matchNum(prize) == Rank.SECOND.getCountOfMatch()) {
                second++;
            }
        }
        return second;
    }

    public int rackFirst(List<Lotto> lottos, List<Integer> prize) {
        int first = 0;
        for (Lotto lotto : lottos) {
            if (lotto.matchNum(prize) == Rank.FIRST.getCountOfMatch()) {
                first++;
            }
        }
        return first;
    }


}

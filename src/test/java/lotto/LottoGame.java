package lotto;

import lotto.domain.BonusBall;
import lotto.domain.Lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoGame {
    private static Map<RankKey, Integer> rank;
    static {
        rank = new HashMap();
        rank.put(new RankKey(6, false), 1);
        rank.put(new RankKey(5, true), 2);
        rank.put(new RankKey(5, false), 3);
        rank.put(new RankKey(4, false), 4);
        rank.put(new RankKey(4, true), 4);
        rank.put(new RankKey(3, false), 5);
        rank.put(new RankKey(3, true), 5);
    }

    public static void main(String[] args) {

    }

    public static int match(String lottoText, String anotherLottoText, String bonusBallText){
        Lotto lotto = Lotto.ofText(lottoText);
        Lotto anotherLotto = Lotto.ofText(anotherLottoText);
        BonusBall bonusBall = BonusBall.ofLottoAndText(anotherLotto, bonusBallText);
        RankKey key = new RankKey(lotto.match(anotherLotto), bonusBall.match(lotto));
        return rank.get(key);
    }
}

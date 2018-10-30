package lotto.domain;

import java.util.*;

public class LottoManager {
    private static Map<Rank, Integer> map = new HashMap<>();

    static {
        map.put(Rank.FIFTH, 0);
        map.put(Rank.FOURTH, 0);
        map.put(Rank.THIRD, 0);
        map.put(Rank.SECOND, 0);
        map.put(Rank.FIRST, 0);
    }

    private List<Lotto> lottos = new ArrayList<>();
    private int money;

    private LottoManager(int money) {
        final int LOTTO_PRICE = 1000;
        this.money = money;
        int count = money / LOTTO_PRICE;

        if (count < 1) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

        for (int i = 0; i < count; i++) {
            addLotto(Lotto.ofAuto());
        }
    }

    public static LottoManager buyLotto(int myMoney) {
        return new LottoManager(myMoney);
    }

    public void winLottoMatch(WinningLotto winLotto) {
        for (int i = 0; i < getSize(); i++) {
            changeMap(winLotto, i);
        }
    }

    public void changeMap(WinningLotto winLotto, int index) {
        int count = winLotto.obtainMatchCount(getLotto(index));
        Rank rank = Rank.valueOf(count, winLotto.isContainBonusBall(getLotto(index)));

        if (count >= Rank.FIFTH.getCountOfMatch() && count <= Rank.FIRST.getCountOfMatch()) {
            map.put(rank, map.get(rank) + 1);
        }
    }

//    public void winLottoMatch(Lotto winLotto, int bonusBall) {
//        for (int i = 0; i < getSize(); i++) {
//            changeMap(winLotto, i, bonusBall);
//        }
//    }

//    public void changeMap(Lotto winLotto, int index, int bonusBall) {
//        int count = winLotto.obtainMatchCount(getLotto(index));
//        Rank rank = Rank.valueOf(count, getLotto(index).obtainMatchBonus(bonusBall));
//
//        if (count >= Rank.FIFTH.getCountOfMatch() && count <= Rank.FIRST.getCountOfMatch()) {
//            map.put(rank, map.get(rank) + 1);
//        }
//    }

//    public LottoManager(int money, String lotto) { // 수동 추가
//        this.money = money;
//        addLotto(Lotto.ofWinLotto(lotto));
//    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize() {
        return lottos.size();
    }

    public long yield() {  // 수익률
        long result = 0;
        for (Rank value : Rank.values()) {
            result += value.getWinningMoney() * map.get(value);
        }
        return result * 100L / money;

//        return ((Rank.FIFTH.getWinningMoney() * map.get(Rank.FIFTH))
//                + (Rank.FOURTH.getWinningMoney() * map.get(Rank.FOURTH))
//                + (Rank.THIRD.getWinningMoney() * map.get(Rank.THIRD))
//                + (Rank.SECOND.getWinningMoney() * map.get(Rank.SECOND))
//                + (Rank.FIRST.getWinningMoney() * map.get(Rank.FIRST))) * 100L / money;
    }
//
//    public int getFifthRank() {
//        return map.get(Rank.FIFTH);
//    }
//
//    public int getFourthRank() {
//        return map.get(Rank.FOURTH);
//    }
//
//    public int getThirdRank() {
//        return map.get(Rank.THIRD);
//    }
//
//    public int getSecondRank() {
//        return map.get(Rank.SECOND);
//    }
//
//    public int getFirstRank() {
//        return map.get(Rank.FIRST);
//    }

    public int getRank(Rank value){
        return map.get(value);
    }
}

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

    private LottoManager(Money money, List<String> manualLottos) {
        makeManualLotto(manualLottos);
        makeAutoLotto(money.autoLottoCount(manualLottos));
    }

    public LottoManager(List<Lotto> manualLotto){
        lottos.addAll(manualLotto);
    }

    private void makeAutoLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add((LottoGenerator.createLotto()));
        }
    }

    private void makeManualLotto(List<String> manualLottos) {
        for (int i = 0; i < manualLottos.size(); i++) {
            lottos.add((Lotto.ofManualLotto(manualLottos.get(i))));
        }
    }

    public static LottoManager buyLotto(Money money, List<String> manualLottos) {
        return new LottoManager(money, manualLottos);
    }

    public void winLottoMatch(WinningLotto winLotto) {
        for (int i = 0; i < getSize(); i++) {
            changeMap(winLotto, i);
        }
    }

    private void changeMap(WinningLotto winLotto, int index) {
        int count = winLotto.obtainMatchCount(getLotto(index));
        Rank rank = Rank.valueOf(count, winLotto.isContainBonusBall(getLotto(index)));
        if (count >= Rank.FIFTH.getCountOfMatch() && count <= Rank.FIRST.getCountOfMatch()) {
            map.put(rank, map.get(rank) + 1);
        }
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize() {
        return lottos.size();
    }

    public int getRank(Rank value){
        return map.get(value);
    }

    public String getMap() {
        return map.toString();
    }
}

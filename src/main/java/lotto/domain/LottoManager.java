package lotto.domain;

import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoManager {
    private static Map<Integer, Integer> map = new HashMap<>();
    static {
        map.put(0, 0);
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    private List<Lotto> lottos = new ArrayList<>();
    private int money;

    public LottoManager(int money) {
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
        LottoManager lottos = new LottoManager(myMoney);
        return lottos;
    }

    public void winLottoMatch(Lotto winLotto) {
        for (int i = 0; i < getSize(); i++) {
            changeMap(winLotto, i);
        }
    }

    public void changeMap(Lotto winLotto, int index) {
        LottoManager.map.put(winLotto.obtainMatchCount(getLotto(index)),
                LottoManager.map.get(winLotto.obtainMatchCount(getLotto(index))) + 1);
    }

    public LottoManager(int money, String lotto) { // 수동 추가
        this.money = money;
        addLotto(Lotto.ofWinLotto(lotto));
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize() {
        return lottos.size();
    }

    public int yield() {  // 수익률
        return ((ResultView.SAME_THREE * LottoManager.map.get(3)) + (ResultView.SAME_FOUR * LottoManager.map.get(4)) +
                (ResultView.SAME_FIVE * LottoManager.map.get(5)) + (ResultView.SAME_SIX * LottoManager.map.get(6))) / money * 100;
    }

    public int sameThree() {
        return map.get(3);
    }

    public int sameFour() {
        return map.get(4);
    }

    public int sameFive() {
        return map.get(5);
    }

    public int sameSix() {
        return map.get(6);
    }
}

package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningRules {

    private enum Type {
        ONE(6, false), TWO(5, false), THREE(4, false), FOUR(3, false), BLANK(0, false);
        private final int trueNum;
        private boolean bonus;

        Type(int num, boolean bonus) {
            this.trueNum = num;
            this.bonus = bonus;
        }

        public static Type getType(int count) {
            for (Type value : values()) {
                if (value.matchNum(count)) {
                    return value;
                }
            }
            return Type.BLANK;
        }

        private boolean matchNum(int count) {
            return this.trueNum == count;
        }
    }

    private Map<Type, Integer> rankMap = new HashMap<>();

    public WinningRules() {
        // key 로또와 당첨번호와 같은 개수, value 등수와 같은 자동로또 수
        for (Type type : Type.values()) {
            rankMap.put(type,0);
        }
    }

    public void matchLotto(List<Lotto> lottos, Lotto winnerLotto) {
        for (Lotto lotto : lottos) {
            increase(winnerLotto.compareLotto(lotto));
        }
    }

    public void increase(int count) {
        if (count >= 3 && count <= 6) {
            rankMap.put(Type.getType(count), rankMap.get(Type.getType(count)) + 1);
        }
    }

    public int ranking(int count) {
        return rankMap.get(Type.getType(count));
    }
}



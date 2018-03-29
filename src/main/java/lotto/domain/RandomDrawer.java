package lotto.domain;

import java.util.Collections;
import java.util.List;

public class RandomDrawer {
    private List<Integer> numberPool;

    RandomDrawer() {
        for (int i = 1; i <= 45; i++) {
            this.numberPool.add(i);
        }
    }

    public List<Integer> drawNumber() {
        Collections.shuffle(numberPool);
        return numberPool.subList(0, 7);
    }
}

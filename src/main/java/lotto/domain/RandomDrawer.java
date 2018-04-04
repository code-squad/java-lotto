package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.WinningLotto.FIRST;
import static lotto.domain.WinningLotto.LAST;

public class RandomDrawer {
    private static final int MIN = 1;
    private static final int MAX = 45;
    private final List<Number> numberPool;

    private RandomDrawer() {
        numberPool = new ArrayList<>();
        for (int i = MIN; i <= MAX; i++) {
            this.numberPool.add(new Number(i));
        }
    }

    public static RandomDrawer
    newInstance() {
        return new RandomDrawer();
    }

    public List<Number>
    drawNumber() {
        Collections.shuffle(numberPool);
        return numberPool.subList(FIRST, LAST);
    }
}
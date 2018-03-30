package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomDrawer {
    private final List<Number> numberPool;

    private RandomDrawer() {
        numberPool = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            this.numberPool.add(new Number(i));
        }
    }

    public static RandomDrawer newInstance() {
        return new RandomDrawer();
    }

    public List<Number> drawNumber() {
        Collections.shuffle(numberPool);
        return numberPool.subList(0, 6);
    }
}
package support;

import domain.Lotto;
import vo.Num;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fixture {
    protected static final Num NUM1 = new Num(1);
    protected static final Num NUM2 = new Num(2);
    protected static final Num NUM3 = new Num(3);
    protected static final Num NUM4 = new Num(4);
    protected static final Num NUM5 = new Num(5);
    protected static final Num NUM6 = new Num(6);
    protected static final Num NUM7 = new Num(7);
    protected static final Num NUM8 = new Num(8);
    protected static final Num NUM9 = new Num(9);
    protected static final Num NUM10 = new Num(10);
    protected static final Num NUM11 = new Num(11);

    protected static final List<Num> LOTTONUMS1 = Arrays.asList(NUM1, NUM2, NUM3, NUM4, NUM5, NUM6);
    protected static final List<Num> LOTTONUMS2 = Arrays.asList(NUM1, NUM2, NUM3, NUM4, NUM5, NUM7);
    protected static final List<Num> LOTTONUMS3 = Arrays.asList(NUM1, NUM2, NUM3, NUM4, NUM7, NUM8);
    protected static final List<Num> LOTTONUMS4 = Arrays.asList(NUM6, NUM7, NUM8, NUM9, NUM10, NUM11);

    protected static final List<Lotto> LOTTOBUNDLE = Arrays.asList(
            Lotto.ofList(LOTTONUMS1),
            Lotto.ofList(LOTTONUMS2),
            Lotto.ofList(LOTTONUMS3),
            Lotto.ofList(LOTTONUMS4)
    );

    protected static final Map<Integer, Integer> RESULT = new HashMap<>();

    static {
        for (int i = 0; i <= Lotto.LOTTOSIZE; i++) {
            RESULT.put(i, 0);
        }
    }
}
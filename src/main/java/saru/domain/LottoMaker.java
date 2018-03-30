package saru.domain;

import java.util.*;

public class LottoMaker {
    private static final int MAX_LOTTO_NUM = 45;
    private List<LottoNumber> baseNumberList = new ArrayList<>();

    private LottoMaker() {
        initBaseNumberList();
    }

    public static LottoMaker of() {
        return new LottoMaker();
    }

    public List<LottoNumber> makeLottoList() {
        Collections.shuffle(baseNumberList);
        List<LottoNumber> subList = baseNumberList.subList(0, 6);
        Collections.sort(subList,
                Comparator.comparingInt(LottoNumber::getNumber));

        return new ArrayList<>(subList);
    }

    private void initBaseNumberList() {
        for (int i = 1; i <= MAX_LOTTO_NUM; i++) {
            baseNumberList.add(LottoNumber.of(i));
        }
    }
}

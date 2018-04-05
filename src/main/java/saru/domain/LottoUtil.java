package saru.domain;

import java.util.*;

public class LottoUtil {
    private LottoUtil() {
        // empty
    }

    public static List<LottoLine> joinLottoLines(List<LottoLine> first, List<LottoLine> second) {
        List<LottoLine> newList = new ArrayList<>(first);
        newList.addAll(second);
        return newList;
    }
}

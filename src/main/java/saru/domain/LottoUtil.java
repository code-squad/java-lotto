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

    public static List<LottoLine> splitManualQueryToLines(String manualQuery) {
        List<String> lottoStrings = splitQuery(manualQuery);

        // 수동 로또들이 리턴
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoLines = new ArrayList<>();

        for (String str : lottoStrings) {
            lottoLines.add(lottoMaker.makeManualLottoLine(str));
        }

        return lottoLines;
    }

    private static List<String> splitQuery(String manualQuery) {
        String[] splitQuery = manualQuery.split("\r?\n");
        return Arrays.asList(splitQuery);
    }
}

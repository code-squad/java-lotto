package lotto.domain;

import lotto.utill.Parser;

import java.util.*;

public class Lotto {
    private List<LottoNo> lotto;

    private Lotto(List<LottoNo> seed) {
        Collections.sort(seed);
        lotto = seed;
    }

    public static Lotto ofAuto(List<LottoNo> seed) {
        return new Lotto(seed);
    }

    public static Lotto ofManualLotto(String text) {
        List<String> manualText = new ArrayList<>(Arrays.asList(Parser.ofComma(text.replace(" ", ""))));
        sizeCheck(manualText);
        return new Lotto(overlapCheck(manualText));
    }

    private static void sizeCheck(List<String> winText) {
        if (winText.size() != 6) {
            throw new IllegalArgumentException("번호를 정확히 입력하세요.");
        }
    }

    private static List<LottoNo> overlapCheck(List<String> manualText) {
        List<LottoNo> winNumber = new ArrayList<>();
        Set<LottoNo> overlapChecker = new HashSet<>();

        for (String s : manualText) {
            winNumber.add(LottoNo.of(s));
            overlapChecker.add(LottoNo.of(s));
        }

        if (winNumber.size() != overlapChecker.size()) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
        return winNumber;
    }

    public LottoNo getOneLotto(int index){
        return lotto.get(index);
    }

    public int size(){
        return lotto.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return lotto + "";
    }
}

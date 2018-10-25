package lotto.domain;

import lotto.dto.LottoDto;
import lotto.utill.Parser;

import java.util.*;

public class Lotto {
    private static final int LOTTO_MIN = 1;
    private static final int LOTTO_MAX = 45;
    private static List<Integer> lottoNo = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoNo.add(i);
        }
    }

    private List<Integer> lotto;

    private Lotto() {
        Collections.shuffle(lottoNo);
        lotto = new ArrayList<>(lottoNo.subList(0, 6));
        Collections.sort(lotto);
    }

    private Lotto(List winNumber) {
        lotto = winNumber;
    }

    public static Lotto ofAuto() {
        return new Lotto();
    }

    public static Lotto ofWinLotto(String text) {
        List<String> winText = new ArrayList<>(Arrays.asList(Parser.ofComma(text)));
        List<Integer> winNumber = new ArrayList<>();
        Set<Integer> overlapChecker = new HashSet<>();

        for (String s : winText) {
            winNumber.add(Integer.parseInt(s));
            overlapChecker.add(Integer.parseInt(s));
        }
        if(winNumber.size() != overlapChecker.size()){
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
        if (winText.size() != 6) {
            throw new IllegalArgumentException("당첨 번호를 정확히 입력하세요.");
        }
        return new Lotto(winNumber);
    }

    public int obtainMatchCount(Lotto other) {
        int count = 0;
        for (Integer number : other.lotto) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public LottoDto toDto(){
        return new LottoDto(lotto);
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
        return lotto.toString();
    }
}

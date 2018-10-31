package lotto.domain;

import lotto.utill.Parser;

import java.util.*;

public class WinningLotto {
    private List<LottoNo> winLotto;
    private LottoNo bonusBall;

    public WinningLotto(String text, LottoNo bonusBall) {
        List<String> winText = new ArrayList<>(Arrays.asList(Parser.ofComma(text.replace(" ", ""))));
        inputSizeCheck(winText);
        this.winLotto = overlapErrorCheck(winText);
        this.bonusBall = bonusBall;
    }

    private void inputSizeCheck(List<String> winText) {
        if (winText.size() != 6) {
            throw new IllegalArgumentException("당첨 번호를 정확히 입력하세요.");
        }
    }

    private List<LottoNo> overlapErrorCheck(List<String> winText) {
        List<LottoNo> winNumber = new ArrayList<>();
        Set<LottoNo> overlapChecker = new HashSet<>();
        for (String s : winText) {
            winNumber.add(LottoNo.of(s));
            overlapChecker.add(LottoNo.of(s));
        }
        if (winNumber.size() != overlapChecker.size()) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
        if (winNumber.contains(bonusBall)) {
            throw new IllegalArgumentException("입력한 보너스 볼이 이미 당첨 번호에 있습니다.");
        }
        return winNumber;
    }

    public int obtainMatchCount(Lotto other) {
        int count = 0;
        for (int i = 0; i < other.size(); i++) {
            if (winLotto.contains(other.getOneLotto(i))) {
                count++;
            }
        }
        return count;
    }

    public boolean isContainBonusBall(Lotto other) {
        for (int i = 0; i < other.size(); i++) {
            if (other.getOneLotto(i).equals(bonusBall)) {
                return true;
            }
        }
        return false;
    }
}

package lotto.domain;

import lotto.utill.Parser;

import java.util.*;

public class WinningLotto {
    private List<Integer> winLotto;
    private int bonusBall;

    public WinningLotto(String text, int bonusBall) {
        List<String> winText = new ArrayList<>(Arrays.asList(Parser.ofComma(text.replace(" ", ""))));
        List<Integer> winNumber = new ArrayList<>();
        Set<Integer> overlapChecker = new HashSet<>();

        for (String s : winText) {
            winNumber.add(Integer.parseInt(s));
            overlapChecker.add(Integer.parseInt(s));
        }
        if (winNumber.size() != overlapChecker.size()) {
            throw new IllegalArgumentException("중복된 값은 입력할 수 없습니다.");
        }
        if (winText.size() != 6) {
            throw new IllegalArgumentException("당첨 번호를 정확히 입력하세요.");
        }

        this.winLotto = winNumber;
        this.bonusBall = bonusBall;
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
            if (other.getOneLotto(i) == bonusBall) {
                return true;
            }
        }
        return false;
    }
}

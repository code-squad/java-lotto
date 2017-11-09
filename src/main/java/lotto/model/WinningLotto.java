package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WinningLotto {
    private List<Integer> lotto;

    public WinningLotto(String lottoNo) {
        String[] values = lottoNo.split(",");
        List<Integer> lotto = new ArrayList<>();
        for (String value : values) {
            lotto.add(Integer.parseInt(value.trim()));
        }
        Collections.sort(lotto);
        this.lotto = lotto;
    }
    
    public Match countOfMatch(List<Integer> lotto) {
        List<Integer> result = new ArrayList<>(lotto);
        result.retainAll(this.lotto);

        if (result.size() < 3) {
            return null;
        }
        return Match.valueOf(result.size());
    }
}

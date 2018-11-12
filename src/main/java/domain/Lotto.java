package domain;


import domain.vo.LottoNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private List<LottoNum> lotto;

    private Lotto(List<LottoNum> lotto) {
        this.lotto = lotto;
        if (this.lotto.size() != new HashSet<>(lotto).size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        Collections.sort(lotto);
    }

    int compareLotto(Lotto otherLotto) {
        return (int) lotto.stream().filter(otherLotto::contains).count();
    }

    boolean contains(LottoNum lottoNum) {
        return lotto.contains(lottoNum);
    }

    private static List<LottoNum> createLotto(List<String> nums) {
        List<LottoNum> list = new ArrayList<>();
        for (String num : nums) {
            list.add(LottoNum.ofString(num));
        }
        return list;
    }


    LottoNum getNum(int i) {
        return lotto.get(i);
    }

    public List<LottoNum> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return "" + getLotto();
    }

    static Lotto ofAuto(List<LottoNum> nums) {
        return new Lotto(nums);
    }

    static Lotto ofManual(List<String> nums) {
        return new Lotto(createLotto(nums));
    }
}

package domain;

import domain.vo.LottoNum;

import java.util.*;

public abstract class AbstractLotto {
    private List<LottoNum> lotto;

    AbstractLotto(List<LottoNum> lotto) {
        this.lotto = lotto;
        if (this.lotto.size() != new HashSet<>(lotto).size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        Collections.sort(lotto);
    }

    int compareLotto(AbstractLotto otherLotto) {
        int count = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(otherLotto.getNum(i))) {
                count++;
            }
        }
        return count;
    }

    static List<LottoNum> createLotto(List<String> nums) {
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

}

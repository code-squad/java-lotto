package domain;


import java.util.ArrayList;
import java.util.Collections;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private List<LottoNum> lotto;

    private Lotto(List<LottoNum> nums) {
        this.lotto = nums;
        Collections.sort(lotto);
    }

    static Lotto autoLottoCreate(List<LottoNum> nums) {
        Collections.shuffle(nums);
        List<LottoNum> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(nums.get(i));
        }
        return new Lotto(list);
    }

    public static Lotto winnerLottoCreate(List<String> nums) {
        List<LottoNum> list = new ArrayList<>();
        Collections.shuffle(nums);
        for (String num : nums) {
            list.add(LottoNum.stringCreate(num));
        }
        if (list.size() != new HashSet<>(list).size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        return new Lotto(list);
    }

    int compareLotto(Lotto otherLotto) {
        int count = 0;
        for (int i = 0; i < this.lotto.size(); i++) {
            if (this.lotto.contains(otherLotto.getNum(i))) {
                count++;
            }
        }
        return count;
    }

    public LottoNum getNum(int i) {
        return lotto.get(i);
    }

    @Override
    public String toString() {
        return "" + lotto;
    }
}

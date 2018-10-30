package domain;


import domain.vo.LottoNum;

import java.util.List;

public class Lotto extends AbstractLotto {

    private Lotto(List<LottoNum> lotto) {
        super(lotto);
    }

    static Lotto ofAuto(List<LottoNum> nums) {
        return new Lotto(nums);
    }

    static Lotto ofManual(List<String> nums) {
        return new Lotto(createLotto(nums));
    }
}

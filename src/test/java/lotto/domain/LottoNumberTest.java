package lotto.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

public class LottoNumberTest {

    @Test(expected = IllegalArgumentException.class)
    public void 로또_한장에_적혀있는_번호가_6개가_아니면_예외발생() {
        new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5));
    }
}
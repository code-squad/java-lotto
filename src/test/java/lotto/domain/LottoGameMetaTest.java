package lotto.domain;

import org.junit.Test;

public class LottoGameMetaTest {


    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성시_메타번호가_1미만이면_예외발생(){
        new LottoMeta(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_생성시_메타번호가_45초과이면_예외발생(){
        new LottoMeta(46);
    }
}
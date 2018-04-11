package lotto.domain;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PrizeEvaluatorTest {

    @Test
    public void 내가_구매한_로또와_당첨된_로또가_같은_갯수반환() {

        // Given
        LottoNumber 내가_구매한_로또_번호 = new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5, 6));
        LottoNumber 당첨된_로또_번호 = new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5 ,6));

        // Then
        long matchCount = PrizeEvaluator.getMatchCount(내가_구매한_로또_번호, 당첨된_로또_번호);
        assertEquals(6, matchCount);
    }
}
package lotto.domain;

import com.google.common.collect.Lists;
import lotto.Prize;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class PrizeCalculatorTest {

    @Test
    public void calculate() {

        // Given
        List<LottoNumber> 내가_구매한_로또_번호 = Lists.newArrayList(
                new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(Lists.newArrayList(7, 8, 9, 10, 11, 12)),
                new LottoNumber(Lists.newArrayList(13, 14, 15, 16, 17, 18))
        );
        LottoNumber 당첨된_로또_번호 = new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5 ,6));
        BonusNumber 보너스_로또_번호 = new BonusNumber(7);

        // Then
        Map<Prize, Integer> 로또_당첨_결과 = PrizeCalculator.calculate(내가_구매한_로또_번호, 당첨된_로또_번호, 보너스_로또_번호);
        assertEquals((Integer)1, 로또_당첨_결과.get(Prize.FIRST));
    }

    @Test
    public void calculateEarningRate() {

        // Given
        List<LottoNumber> 내가_구매한_로또_번호 = Lists.newArrayList(
                new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5, 6)),
                new LottoNumber(Lists.newArrayList(7, 8, 9, 10, 11, 12)),
                new LottoNumber(Lists.newArrayList(13, 14, 15, 16, 17, 18)),
                new LottoNumber(Lists.newArrayList(13, 14, 15, 16, 17, 18)),
                new LottoNumber(Lists.newArrayList(13, 14, 15, 16, 17, 18))
        );
        LottoNumber 당첨된_로또_번호 = new LottoNumber(Lists.newArrayList(1, 2, 3, 4, 5 ,6));
        BonusNumber 보너스_로또_번호 = new BonusNumber(7);

        Map<Prize, Integer> calculate = PrizeCalculator.calculate(내가_구매한_로또_번호, 당첨된_로또_번호, 보너스_로또_번호);
        int calculateEarningRate = PrizeCalculator.calculateEarningRate(5000, calculate);


        // Then
        assertEquals(40000000, calculateEarningRate);

    }
}
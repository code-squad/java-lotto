package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoNoTest {
    @Test
    public void lottoNoTest() {
        LottoNo lottoNo = new LottoNo(5);
        assertThat(lottoNo).isEqualTo(new LottoNo(5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_under_valid_variation_test() {
        new LottoNo(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest_over_valid_variation_test() {
        new LottoNo(46);
    }

    public static List<LottoNo> toLottoNos(List<Integer> integers) {
        List<LottoNo> lottoNos = new ArrayList<>(integers.size());

        for(int integer : integers)
            lottoNos.add(new LottoNo(integer));

        return lottoNos;
    }
}

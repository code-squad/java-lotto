package domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumTest {

    @Test
    public void LottoNum_값_등호_테스트() {
        LottoNum num1 = LottoNum.ofLottoNum(3);
        LottoNum num2 = LottoNum.ofLottoNum(3);
        assertThat(num1.equals(num2)).isEqualTo(true);
    }
}
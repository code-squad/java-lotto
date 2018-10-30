package domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumTest {

    @Test
    public void LottoNum_값_등호_테스트() {
        LottoNum num1 = new LottoNum(3);
        LottoNum num2 = new LottoNum(3);
        assertThat(num1.equals(num2)).isEqualTo(true);
    }
}
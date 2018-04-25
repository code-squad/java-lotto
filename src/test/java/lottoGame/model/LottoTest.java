package lottoGame.model;

import lottoGame.model.Lotto;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void test_Lotto_getStrings(){
        assertThat(Lotto.getStrings("1,2,3,4,5,6")).contains("1");
        assertThat(Lotto.getStrings("1,2,3,4,5,6")).contains("6");
    }

    @Test
    public void test_Lotto_ofComma(){
        assertThat(Lotto.ofComma("1,2,3,4,5,6").getLottoNumbersToList()).contains(new LottoNumbers(1));
        assertThat(Lotto.ofComma("45,23,12,32,42,11").getLottoNumbersToList()).contains(LottoNumbers.of(42));

    }

    @Test
    public void test_Lotto_isNumberMatch(){
        assertThat(Lotto.ofComma("1,2,3,4,5,6").isNumberMatch(LottoNumbers.of(3))).isEqualTo(true);
        assertThat(Lotto.ofComma("1,2,3,4,5,6").isNumberMatch(LottoNumbers.of(7))).isEqualTo(false);
    }
}

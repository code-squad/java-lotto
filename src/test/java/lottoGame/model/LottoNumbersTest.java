package lottoGame.model;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    public void test_LottoNumbers_checkValidation_validation(){
        assertThat(LottoNumbers.checkValidation(1).getInteger()).isEqualTo(1);
        assertThat(LottoNumbers.checkValidation(45).getInteger()).isEqualTo(45);
    }

    @Test(expected=IllegalArgumentException.class)
    public void test_LottoNumbers_checkValidation_unvalidation(){
        assertThat(LottoNumbers.checkValidation(47));
        assertThat(LottoNumbers.checkValidation(0));
    }

    @Test
    public void test_LottoNumbers_of(){
        assertThat(LottoNumbers.of(1).getInteger()).isEqualTo(1);
        assertThat(LottoNumbers.of("45").getInteger()).isEqualTo(45);
    }

}

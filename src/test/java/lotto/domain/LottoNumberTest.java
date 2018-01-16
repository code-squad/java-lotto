package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoNumberTest {

    @Test
    public void 수동번호생성() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoNumber lottoNumber = new LottoNumber(numbers);
        assertThat(lottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(lottoNumber.getNumbers().stream().distinct().count()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_잘못된숫자갯수() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        LottoNumber lottoNumber = new LottoNumber(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_중복숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);
        LottoNumber lottoNumber = new LottoNumber(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동번호생성_범위를_넘어가는_숫자() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 46);
        LottoNumber lottoNumber = new LottoNumber(numbers);
    }

    @Test
    public void 자동번호생성() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getNumbers().size()).isEqualTo(6);
        assertThat(lottoNumber.getNumbers().stream().distinct().count()).isEqualTo(6);
    }

    @Test
    public void 다른로또번호와비교() {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(6, 7, 8, 9, 10, 11);
        List<Integer> numbers3 = Arrays.asList(7, 8, 9, 10, 11, 12);

        LottoNumber lottoNumber1 = new LottoNumber(numbers1);
        LottoNumber lottoNumber2 = new LottoNumber(numbers1);
        LottoNumber lottoNumber3 = new LottoNumber(numbers2);
        LottoNumber lottoNumber4 = new LottoNumber(numbers3);

        assertThat(lottoNumber1.countMatchNumber(lottoNumber2)).isEqualTo(6);
        assertThat(lottoNumber1.countMatchNumber(lottoNumber3)).isEqualTo(1);
        assertThat(lottoNumber1.countMatchNumber(lottoNumber4)).isEqualTo(0);
    }
}
package model;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    public void 숫자_맞추기() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<Integer> numbers = Arrays.asList(10, 11, 12, 13, 14, 15);
        assertThat(lottoNumbers.checkTheWinningNumbers(numbers)).isEqualTo(0);
        numbers = Arrays.asList(1, 2, 3, 7, 8, 9);
        assertThat(lottoNumbers.checkTheWinningNumbers(numbers)).isEqualTo(3);
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumbers.checkTheWinningNumbers(numbers)).isEqualTo(6);
    }
}

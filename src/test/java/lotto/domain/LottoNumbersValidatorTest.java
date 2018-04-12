package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumbersValidatorTest {

    @Test
    public void 유효한_로또_번호를_가지면_예외가_발생하지_않는다() {
        LottoNumbersValidator.validate(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호가_6개가_아니면_예외발생() {
        //given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);

        //when
        LottoNumbersValidator.validate(fiveNumbers);

        //then
        Assertions.fail("로또 번호가 6개가 아니면 예외가 발생해야 한다");
    }


    @Test(expected = IllegalArgumentException.class)
    public void 숫자_1보다_작은수가_포함되면_예외발생() {
        //given
        List<Integer> invalidMinNumber = Arrays.asList(0, 2, 3, 4, 5, 6);

        //when
        LottoNumbersValidator.validate(invalidMinNumber);

        //then
        Assertions.fail("로또 번호가 1보다 작은수가 포함되면 예외가 발생해야 한다");
    }


    @Test(expected = IllegalArgumentException.class)
    public void 숫자_45보다_큰수가_포함되면_예외발생() {
        //given
        List<Integer> invalidMinNumber = Arrays.asList(1, 2, 3, 4, 5, 46);

        //when
        LottoNumbersValidator.validate(invalidMinNumber);

        //then
        Assertions.fail("로또 번호가 45보다 큰수가 포함되면 예외가 발생해야 한다");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 중복된_수가_포함되면_예외발생() {
        //given
        List<Integer> invalidMinNumber = Arrays.asList(1, 2, 3, 4, 5, 5);

        //when
        LottoNumbersValidator.validate(invalidMinNumber);

        //then
        Assertions.fail("로또 번호가 중복되면 예외가 발생해야 한다");
    }
}
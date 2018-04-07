package calculator;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    public void inputNullReturnZero() {
        Calculator calculator = new Calculator();
        int calculateResult = calculator.calculate("");
        assertThat(calculateResult).isEqualTo(0);
    }
}

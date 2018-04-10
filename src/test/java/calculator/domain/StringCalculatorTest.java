package calculator.domain;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
	private StringCalculator calculator;
	
	@Before
	public void setUp() throws Exception {
		calculator = new StringCalculator(",", ":");
	}
	
	@Test
	public void 빈문자열_null_add테스트() {
		assertThat(calculator.calculate("")).isEqualTo(0);
	}
	
	@Test
	public void 숫자하나_add테스트() {
		assertThat(calculator.calculate("2")).isEqualTo(2);
	}
	
	@Test
	public void 여러숫자컴마_add테스트() {
		assertThat(calculator.calculate("2,3")).isEqualTo(5);
	}
	
	@Test
	public void 여러숫자콜론_add테스트() {
		assertThat(calculator.calculate("2:3")).isEqualTo(5);
	}
	
	@Test
	public void 여러숫자컴마콜론_add테스트() {
		assertThat(calculator.calculate("2,3:5")).isEqualTo(10);
	}
	
	@Test(expected = RuntimeException.class)
	public void 음수_add테스트() {
		calculator.calculate("-1,3");
	}
	
	@Test(expected = RuntimeException.class)
	public void 잘못된계산형식_add테스트() {
		calculator.calculate(";3+4");
	}
	
	@Test
	public void 커스텀구분자_add테스트() {
		assertThat(calculator.calculate("//;\n2;3")).isEqualTo(5);
	}
}

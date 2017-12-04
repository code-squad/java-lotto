import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LottoTest {
	
	Lotto lotto;
	
	@Before
	public void setup() {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);
		lotto = new Lotto(numbers);
	}

	@Test
	public void test() {
		List<Integer> luckyNumbers = Arrays.asList(1,2,3,45,44,43);
		assertEquals(3, lotto.makeMatchingCount(luckyNumbers));
	}
	
	@After
	public void tearDown() {
		lotto = null;
	}

}

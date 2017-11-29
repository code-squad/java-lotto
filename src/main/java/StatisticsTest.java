import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class StatisticsTest {

	@Test
	public void checkMatchingCount메소드확인() {
		List<Integer> temp1 = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> temp2 = Arrays.asList(7, 8, 9, 10, 11, 12);
		Lotto lotto1 = new Lotto(temp1);
		Lotto lotto2 = new Lotto(temp2);
		List<Lotto> lottoSets = Arrays.asList(lotto1, lotto2);
		List<Integer> luckyNumber = Arrays.asList(3, 4, 5, 6, 7, 8);
		int[] matchingCounts = { 4, 2 };
		int[] result = Statistics.checkMatchingCount(lottoSets, luckyNumber);
		assertEquals(matchingCounts[0], result[0]);
		assertEquals(matchingCounts[1], result[1]);
	}
}
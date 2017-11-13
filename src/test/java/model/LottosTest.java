package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LottosTest {
	Lottos lottos;
	
	@Before
	public void setUp() {
		lottos = new Lottos(Arrays.asList(Prize.FIFTH, Prize.FIFTH, Prize.ZERO, Prize.ZERO, Prize.ZERO), 10000);
	}
	@Test
	public void 통계_5등_갯수() {
		assertEquals(2, lottos.getRankCount("FIFTH"));
	}

	public void 수익률() {
		assertEquals(50, lottos.earningRate(5000), 0.5);
	}

}

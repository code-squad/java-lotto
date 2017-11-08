package com.jiwon.lotto;

import static org.junit.Assert.*;

import org.junit.Test;

import com.jiwon.lotto.lottocreator.ManualLotto;

public class ManualLottoTest {

	@Test
	public void create() {
		ManualLotto manualLotto = new ManualLotto();
		manualLotto.create("6,5,4,3,2,1");
		assertEquals(6, manualLotto.create("6,5,4,3,2,1").getNumbers().size());
	}

}

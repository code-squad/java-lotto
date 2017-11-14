package com.jiwon.lotto.lottocreator;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class LottoCreatorTest {

	@Test
	public void manualLotto_생성_테스트() {
		List<String> lottoNumStrings = new ArrayList<>();
		lottoNumStrings.add("1,2,3,4,5,6");
		LottoCreator.makeManualLottos(1, lottoNumStrings);
		assertNotNull(LottoCreator.makeManualLottos(1, lottoNumStrings));
	}

}

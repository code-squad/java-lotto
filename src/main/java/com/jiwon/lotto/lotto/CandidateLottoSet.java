package com.jiwon.lotto.lotto;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CandidateLottoSet {
	private List<Lotto> candidateLottoSet;
	
	public CandidateLottoSet(List<ManualLotto> manualLottos, List<AutoLotto> autoLottos) {
		// candidateLottos 만드는 메소드.
		candidateLottoSet = new ArrayList<>();		
		candidateLottoSet.addAll(manualLottos);
		candidateLottoSet.addAll(autoLottos);
	}

	public List<Lotto> getCandidateLottoSet() {
		return candidateLottoSet;
	}
}

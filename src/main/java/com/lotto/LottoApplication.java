package com.lotto;

import com.lotto.container.LottoContainer;

public class LottoApplication {
	
	public static void main(String[] args) {
		LottoContainer lc = LottoContainer.getInstance();
		
		lc.initialize();
		lc.execute();
	}
}

package com.jiwon.lotto.view;

import java.util.List;

import com.jiwon.lotto.data.InputValue;
import com.jiwon.lotto.lotto.AutoLotto;
import com.jiwon.lotto.lotto.CandidateLottoSet;
import com.jiwon.lotto.lotto.ManualLotto;
import com.jiwon.lotto.lotto.WinningLotto;
import com.jiwon.lotto.lottocreator.LottoCreator;
import com.jiwon.lotto.winstats.WinStats;

public class Main {

	public static void main(String[] args) {
		InputValue inputValue = InputView.createValue();
		int investingAmount = inputValue.getMoney();
		List<AutoLotto> autoLottos = LottoCreator.makeAutoLottos(inputValue.getNumOfAutoLotto());
		List<ManualLotto> manualLottos = LottoCreator.makeManualLottos(inputValue.getNumOfManualLotto(), inputValue.getManualLottoNums());
		CandidateLottoSet candidateLottoSet = new CandidateLottoSet(manualLottos, autoLottos);
		WinningLotto winningLotto = LottoCreator.makeWinningLotto();
		WinStats winStats = winningLotto.makeStats(candidateLottoSet);
		ResultView.print(candidateLottoSet, winningLotto, winStats, investingAmount);
	}
}

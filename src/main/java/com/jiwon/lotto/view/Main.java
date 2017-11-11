package com.jiwon.lotto.view;
import java.util.List;

import com.jiwon.lotto.lotto.AutoLotto;
import com.jiwon.lotto.lotto.CandidateLottoSet;
import com.jiwon.lotto.lotto.ManualLotto;
import com.jiwon.lotto.lotto.WinningLotto;
import com.jiwon.lotto.lottocreator.LottoCreator;
import com.jiwon.lotto.winstats.WinStats;

public class Main {


	public static void main(String[] args) {
		int investingAmount = InputView.getMoney();
		ResultView.printNumOfLotto(investingAmount / 1000);
		int numOfAutoLotto = InputView.getNumOfAutoLotto();
		int numOfManualLotto = InputView.getNumOfManualLotto();
		List<String> lottoNumStrings = InputView.getManualLottoNum(numOfManualLotto);
		List<AutoLotto> autoLottos = LottoCreator.makeAutoLottos(numOfAutoLotto);
		List<ManualLotto> manualLottos = LottoCreator.makeManualLottos(numOfManualLotto, lottoNumStrings);
		CandidateLottoSet candidateLottoSet = new CandidateLottoSet(manualLottos, autoLottos);
		ResultView.printAllLottos(candidateLottoSet);
		WinningLotto winningLotto = LottoCreator.makeWinningLotto();
		ResultView.printWinningNum(winningLotto);
		WinStats.confirmCounts(candidateLottoSet, winningLotto);
		ResultView.printWinStats(WinStats.createResults(candidateLottoSet, winningLotto));
		String totalProfit = WinStats.calculateTotalProfit(investingAmount, WinStats.getTotalWinnedMoney());
		ResultView.printTotalProfit(totalProfit);
	}

}

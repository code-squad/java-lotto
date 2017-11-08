package com.jiwon.lotto.view;

import java.util.List;

import com.jiwon.lotto.winstats.WinStats;

public class Main {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		ResultView resultView = new ResultView();
		int investingAmount = inputView.getMoney();
		resultView.printNumOfLotto(investingAmount/1000);
		int numOfAutoLotto = inputView.getNumOfAutoLotto();
		int numOfManualLotto = inputView.getNumOfManualLotto();
		List<String> usrInputs = inputView.getManualLottoNum(numOfManualLotto);
		WinStats winStats = new WinStats(numOfManualLotto, numOfAutoLotto, usrInputs);
		resultView.printAllLottos(winStats.getCandidateLottos());
		if(inputView.getLottery().equals("lottery")) {
			resultView.printWinningNum();
		}
		resultView.printWinStats(winStats.createResults(winStats.getCandidateLottos()));
		System.out.println(winStats.calTotalProfit(investingAmount));
	}

}

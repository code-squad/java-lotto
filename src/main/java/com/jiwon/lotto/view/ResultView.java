package com.jiwon.lotto.view;

import java.util.List;

import com.jiwon.lotto.lotto.Lotto;
import com.jiwon.lotto.lottocreator.WinningLotto;

public class ResultView {
	public void printNumOfLotto(int value) {
		System.out.println(value + "개를 구매했습니다.");	
	}
	public void printAllLottos(List<Lotto> candidateLottos) {
		for(Lotto candidateLotto : candidateLottos) {
			System.out.print(candidateLotto.getNumbers());
			System.out.println("\n");
		}
	}
	public void printWinningNum() {
		WinningLotto winningLotto = new WinningLotto();
		System.out.println("추첨한 당첨번호는?");
		System.out.println(winningLotto.getWinningLotto());
		System.out.println("추첨한 보너스번호는?");
		System.out.println(winningLotto.getBonusNum());
	}
	public void printWinStats(List<String> results) {
		System.out.println("당첨 통계");
		System.out.println("----------");
		for(String result : results) {
			System.out.println(result);
		}
	}
	
}

package com.jiwon.lotto.winstats;

import java.util.ArrayList;
import java.util.List;

import com.jiwon.lotto.lotto.Lotto;
import com.jiwon.lotto.lottocreator.AutoLotto;
import com.jiwon.lotto.lottocreator.ManualLotto;
import com.jiwon.lotto.lottodrawing.LottoDrawing;

public class WinStats {
// 당첨통계 관리 클래스.
	private List<Lotto> candidateLottos = new ArrayList<>();
	List<Integer> counts = new ArrayList<>();
	
	public List<Lotto> getCandidateLottos() {
		return candidateLottos;
	}

	public WinStats(int numOfManualLotto, int numOfAutoLotto, List<String> usrInputs) {
		AutoLotto autoLotto = new AutoLotto();
		autoLotto.makeAutoLottos(numOfAutoLotto).stream().forEach(s -> candidateLottos.add(s));
		ManualLotto manualLotto = new ManualLotto();
		manualLotto.makeManualLottos(numOfManualLotto, usrInputs).stream().forEach(s -> candidateLottos.add(s));
	}

	public enum Result {
		RANK1(6, 2000000000, 0, false), RANK2(5, 30000000, 0, true), 
		RANK3(5, 1500000, 0, false), RANK4(4, 50000, 0, false), RANK5(3, 5000, 0, false);
		
		private int money;
		private int matchUpNum;
		private int count;
		private boolean isMatchUpWithBonus;
		
		Result(int matchUpNum, int money, int count, boolean isMatchUpWithBonus){
			this.matchUpNum = matchUpNum;
			this.money = money;
			this.count = count;
			this.isMatchUpWithBonus = isMatchUpWithBonus;
		}
		
		public int getCount() {
			return count;
		}
		
		public void updateCount() {
			this.count++;
		}
		
		public static Result selectTargetResult(int matchUpNum) {
			// 해당 Result 반환하는 메소드.
			for(Result r : Result.values()) {
				if(r.matchUpNum == matchUpNum) {
					return r;
				}
				if(matchUpNum == 5 && r.isMatchUpWithBonus) {
					return RANK2;
				}		
			}
			return null;
		}
		
		
	}
	public void confirmCounts(List<Lotto> lottos) {
		// count 확정하는 메소드.
		LottoDrawing lottoDrawing = new LottoDrawing();
			for(Lotto lotto : lottos) {
				if(lottoDrawing.compare(lotto) >= 3) {
					Result targetResult = Result.selectTargetResult(lottoDrawing.compare(lotto));
					targetResult.updateCount();
				}
		}
	}


	public String createResult(Result r, List<Lotto> lottos) {
		confirmCounts(lottos);
		String result = "";
		if(r.isMatchUpWithBonus) {
			result = r.matchUpNum + "개 일치, 보너스 볼 일치"+
						"(" + r.money + ")" + "-" + r.count + "개";
				return result;
		}
		result = r.matchUpNum + "개 일치" +
				"(" + r.money + "원)" + "-" + r.count + "개";
		return result;			
	}
	public int getTotalWinnedMoney() {
		int totalMoney = 0;
		for(Result r : Result.values()) {
			totalMoney += r.count * r.money;
		}
		return totalMoney;
	}
	public List<String> createResults(List<Lotto> lottos){
		List<String> results = new ArrayList<>();
		for(Result r : Result.values()) {
			results.add(createResult(r, lottos));
		}
		return results;
	}
	public String calTotalProfit(int investingAmount){
		double profit = Math.round((double)getTotalWinnedMoney() / investingAmount *100);
		if(profit>=0) {
			return "총 수익률은" + profit + "%입니다.";
		}
		return "총 수익률은" + "-" + profit + "%입니다.";
	}
}

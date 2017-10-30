package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

	List<Lotto> lottos = new ArrayList<Lotto>();
	List<Integer> rank = new ArrayList<Integer>();
	Map<String, Integer> rankCount = new HashMap<String, Integer>();
	int earningMoney = 0;
	
	public List<Lotto> getLottos() {
		return lottos;
	}
	
	public void makeLottos(int count) {
		for(int i=0; i < count; i++) {
			Lotto lo = new Lotto();
			lo.makeLotto();
			lottos.add(lo);
		}
	}
	
	public void makeManualLottos(int count, List<String> manualLottos) {
		for(String manualLotto : manualLottos) {
			Lotto lo = new Lotto();
			lo.makeManualLotto(manualLotto);
			lottos.add(lo);
		}
	}
	
	public void checkLottos(WinningLotto winningLotto) {
		for(Lotto lotto : lottos) {
			checkLottoNum(lotto, winningLotto);
		}
	}
	
	public void checkLottoNum(Lotto lotto,WinningLotto winningLotto) {
		for(int num : winningLotto.getList()) {
			lotto.isCommon(num);
		}
	}
	
	public void resetMap() {
		rankCount.put("fifth", 0);
		rankCount.put("fourth", 0);
		rankCount.put("third", 0);
		rankCount.put("second", 0);
		rankCount.put("first", 0);
	}
	
	public void sumMoney(Lotto lotto, int bonus) {
		int lottoCount = lotto.getCommonCount();
		switch (lottoCount) {
		case 3:
			earningMoney += 5000;
			rankCount.put("fifth",rankCount.get("fifth") + 1);
			break;
		case 4:
			earningMoney += 50000;
			rankCount.put("fourth",rankCount.get("fourth") + 1);
			break;
		case 5:
			//보너스 일치
			if(lotto.isBonusCommon(bonus)) {
				earningMoney += 30000000;
				rankCount.put("second",rankCount.get("second") + 1);
				
			}else {
				earningMoney += 1500000;
				rankCount.put("third",rankCount.get("third") + 1);
			}
			break;
		case 6:
			earningMoney += 2000000000;
			rankCount.put("first", rankCount.get("first") + 1);
			break;
		}
	}
	
	public void statistic(int bonus) {
		resetMap();
		for(Lotto lotto : lottos) {
			sumMoney(lotto, bonus);
		}
	}
/*	public int statistic(int commonNum) {
		int lottoCount = 0;
		for(Lotto lotto : lottos) {
			if(commonNum == lotto.getCommonCount()) {
				lottoCount ++;
			}
		}
		sumMoney(commonNum, lottoCount);
		return lottoCount;
	}
*/	
	
	public int getRankCount(String rank) {
		return rankCount.get(rank);
	}
/*
	public int statisticSecond(int bonus) {
		int lottoCount = 0;
		for(Lotto lotto : lottos) {
			if((5 == lotto.getCommonCount()) && lotto.isBonusCommon(bonus)) {
				lottoCount ++;
			}
		}
		return lottoCount;
	}
*/	
	public double earningRate(double buyMoney) {
		//리턴타입 int면 0으로 나옴. 계산하는 수가 다 int인데 계산 결과가 0보다 작으면 또 0으로 나옴
		return (earningMoney / buyMoney) * 100;
	}
}

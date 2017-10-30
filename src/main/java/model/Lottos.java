package model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

	List<Lotto> lottos = new ArrayList<Lotto>();
	WinningLotto winningLotto = null;
	int earningMoney = 0;
	
	public List<Lotto> getLottos() {
		return lottos;
	}

	public void makeWinningLottos() {
		winningLotto = new WinningLotto();
	}

	public List<Integer> getWinningNumber() {
		return winningLotto.getList();
	}
	
	public int getBonus() {
		return winningLotto.getBonus();
	}
	
	public void makeLottos(int count) {
		for(int i=0; i < count; i++) {
			Lotto lo = new Lotto();
			lottos.add(lo);
		}
	}
	
	public void makeManualLottos(int count, List<String> manualLottos) {
		for(String manualLotto : manualLottos) {
			Lotto lo = new Lotto(manualLotto);
			lottos.add(lo);
		}
	}
	
	public void checkLottos() {
		for(Lotto lotto : lottos) {
			checkLottoNum(lotto);
		}
	}
	
	public void checkLottoNum(Lotto lotto) {
		for(int num : getWinningNumber()) {
			lotto.isCommon(num);
		}
		System.out.println("공통:" + lotto.getCommonCount());
	}
	
	public void sumMoney(int commonNum, int lottoCount) {
		switch (commonNum) {
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
		}
	}
	
	public int statistic(int commonNum) {
		int lottoCount = 0;
		for(Lotto lotto : lottos) {
			if(commonNum == lotto.getCommonCount()) {
				lottoCount ++;
			}
		}
		return lottoCount;
	}
	
	public int statisticSecond(int bonus) {
		int lottoCount = 0;
		for(Lotto lotto : lottos) {
			if((5 == lotto.getCommonCount()) && lotto.isBonusCommon(bonus)) {
				lottoCount ++;
			}
		}
		return lottoCount;
	}
}

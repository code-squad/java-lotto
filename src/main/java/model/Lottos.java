package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

	List<Lotto> lottos = new ArrayList<>();
	List<Prize> prizes = new ArrayList<>();
	int earningMoney = 0;
	
	public Lottos() {}
	//테스트용
	public Lottos(List<Prize> prizes, int earningMoney) {
		this.prizes = prizes;
		this.earningMoney = earningMoney;
	}
	
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
	
	public void makeManualLottos(List<String> manualLottos) {
		for(String manualLotto : manualLottos) {
			Lotto lo = new Lotto();
			lo.makeManualLotto(manualLotto);
			lottos.add(lo);
		}
	}
	
	public void checkLottos(WinningLotto winningLotto) {
		for(Lotto lotto : lottos) {
			winningLotto.match(lotto);
		}
	}

	public void sumMoney(Lotto lotto, int bonus) {
		earningMoney += lotto.getPrice(bonus);
	}
	
	public void statistic(int bonus) {
		for(Lotto lotto : lottos) {
			sumMoney(lotto, bonus);
			prizes.add(lotto.getPrize(bonus)); 
		}
	}
	
	public int getRankCount(String prizeName) {
		return (int)prizes.stream().filter(prize -> prize.name().equals(prizeName)).count();
	}

	public double earningRate(double buyMoney) {
		//계산 결과가 소수일 때 1)계산하는 수가 다 int -> 0출력, 2)리턴타입 int -> 0출력
		return (earningMoney / buyMoney) * 100;
	}
}

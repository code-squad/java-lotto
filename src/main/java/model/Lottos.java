package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

	List<Lotto> lottos;
	List<Prize> prizes;
	int earningMoney = 0;
	
	private Lottos(List<Lotto> lottos){
		this.lottos = lottos;
	}
	
	//테스트용
	public Lottos(List<Prize> prizes, int earningMoney) {
		this.prizes = prizes;
		this.earningMoney = earningMoney;
	}
	
	public static Lottos of(int count) {
		return new Lottos(makeLottos(count));
	}
	
	public static Lottos of(List<String> manualLottos) {
		return new Lottos(makeManualLottos(manualLottos));
	}

	public static List<Lotto> makeLottos(int count) {
		List<Lotto> lottos = new ArrayList<>();
		for(int i=0; i < count; i++) {
			Lotto lo = Lotto.of();
			lottos.add(lo);
		}
		return lottos;
	}
	
	public static List<Lotto> makeManualLottos(List<String> manualLottos) {
		List<Lotto> lottos = new ArrayList<>();
		for(String manualLotto : manualLottos) {
			Lotto lo = Lotto.of(manualLotto);
			lottos.add(lo);
		}
		return lottos;
	}
	
	public List<Lotto> getLottos() {
		return lottos;
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
		 prizes = new ArrayList<>();
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

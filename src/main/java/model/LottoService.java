package model;

import java.util.List;

public class LottoService {

	private Money money = null;
	Lottos lottos = null;
	
	public Lottos beginAuto(int count) {
		lottos = new Lottos();
		lottos.makeLottos(count);
		return lottos;
	}

	public Lottos beginManual(int count, List<String> manualLottos) {
		lottos = new Lottos();
		lottos.makeManualLottos(count, manualLottos);
		return lottos;
	}
	
	public void makeWinningLotto() {
		lottos.makeWinningLottos();
	}
	
	public void checkLottos() {
		lottos.checkLottos();
	}
}

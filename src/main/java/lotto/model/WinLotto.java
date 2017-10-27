package lotto.model;

import java.util.Collections;

public class WinLotto extends Lotto {

	private int bonusBall;

	public WinLotto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WinLotto(String lottoNumber) {
		super(lottoNumber);
		// TODO Auto-generated constructor stub
	}

	public boolean matchingBonusNumber(int number) {
		return number == bonusBall;
	}

	public boolean compareBonusBall(Lotto lotto) {
		return numbers.contains(bonusBall);
	}

	// 로또 추첨번호들이 들어간 리스트를 셔플하고 로또의 번호 숫자만큼 잘라내 로또 생성 winLottos에서는 보너스 볼까지 생성
	@Override
	protected void purchaseAuto() {
		Collections.shuffle(inputNumberList);
		numbers.addAll(inputNumberList.subList(0, LOTTOCOUNT));
		Collections.sort(numbers);
		bonusBall = inputNumberList.get(LOTTOCOUNT + 1);
	}
}
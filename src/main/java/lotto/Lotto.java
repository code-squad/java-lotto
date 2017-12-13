package lotto;

import java.util.ArrayList;

public class Lotto {
	protected ArrayList<Integer> num = new ArrayList<Integer> ();
	//수동 번호 로또를 생성해주는 생성자.
	public Lotto(ArrayList<Integer> num) {
		this.num = num;
	}
	//각 로또 티켓마다의 번호를 확인하는 (리턴하는) 메소드.
	public ArrayList<Integer> getNum() {
		return this.num;
	}
	//각 티켓마다 winningNum과 일치하는 숫자의 수를 계산하고, 일치하는 숫자의 수에 해당하는 match를 리턴한다.
	public Match matchCount(WinningLotto winningLotto) {
		int count = 0;
		ArrayList<Integer> winningNum = winningLotto.getNum();
		for (int i = 0; i < winningNum.size(); i++) {		//보너스 번호를 제외한 6개의 숫자만 비교하여 몇개 일치하는지 리턴해준다.
			count += findToMatch(winningNum.get(i));
		}
		return makeRank(count, winningLotto.getBonusNum());
	}
	//winningNum의 숫자가 티켓 안에 있다면 1을 리턴, 없다면 0을 리턴. (상위 메소드에서 count값을 증가시키기 위함)
	private int findToMatch(int winningNum) {
		if (this.num.contains(winningNum)) {
			return 1;
		}
		return 0;
	}
	//맞은 갯수를 가지고 등수로 변환시켜주는 메소드.
	private Match makeRank(int count, int bonus) {
		Match match = Match.valueOf(count, this.num.contains(bonus));		//맞은 갯수와 보너스 번호가 일치하는지 여부를 보내서 일치하는 Match를 불러온다.
		return match;		//그 Match 를 받아와서 리턴한다.
	}
}

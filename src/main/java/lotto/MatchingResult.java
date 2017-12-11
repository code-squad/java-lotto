package lotto;

public class MatchingResult {
	private Match match;
	private int countOfMatch;
	
	public MatchingResult(Match match) {
		this.match = match;
	}
	//일치하는 Match가 있다면 countOfMatch를 1 증가시킨다. (갯수를 카운트하기 위함.)
	public void match() {
		this.countOfMatch++;
	}
	//현재까지 카운트 된 수를 리턴한다.
	public int returnCount() {
		return this.countOfMatch;
	}

	//현재 어떤 Match가 ArrayList안에 들어있는지 확인하기 위해 Match를 리턴한다.
	public Match returnMatch() {
		return this.match;
	}
	//현재의 Match 가 몇 개 있고, 그 갯수만큼 벌어들인 돈이 얼마인지 계산해준다.
	public int winningMoney() {
		return this.match.getWinningMoney() * this.countOfMatch;
	}
	//parameter로 받은 Match와 현재의 Match가 같은 것인지 확인하여 True/False 를 리턴해주는 메소드.
	public boolean isMatch(Match match) {
		return this.match == match;
	}
}

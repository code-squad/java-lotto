package lotto;

import java.util.ArrayList;

public class Lottos {
	private ArrayList<Lotto> tickets = new ArrayList<Lotto> ();
	
	//lotto 추가 메소드.
	public void add(Lotto lotto) {
		tickets.add(lotto);
	}
	//로또 뭉치를 리턴해주는 메소드.
	public ArrayList<Lotto> get() {
		return this.tickets;
	}
	//각 티켓 별 맞은 갯수를 리스트에 저장하고, 리턴해주는 메소드.
	public ArrayList<Match> makeMatchList(ArrayList<Integer> winningNum, int bonus) {
		ArrayList<Match> matchList = new ArrayList<Match> ();		//티켓 별 맞은 번호 수를 등수로 변환하여 저장하는 리스트를 만들어준다.
		for (int i = 0; i < tickets.size(); i++) {
			Lotto oneTicket = tickets.get(i);
			matchList.add(oneTicket.matchCount(winningNum, bonus));		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 몇개가 일치하는지를 등수로 변환하여 리스트에 넣어줌.
		}
		return matchList;		//등수들이 저장되어 있는 리스트를 리턴한다.
	}
	//최종 결과 리스트를 만들어주는 메소드.
	public ArrayList<MatchingResult> makeResult() {
		ArrayList<MatchingResult> result = new ArrayList<MatchingResult> ();		//최종 결과를 저장할 리스트.
		for(Match match: Match.values()) {
			result.add(new MatchingResult(match));
		}
		return result;
	}
	//MatchingResult ArrayList의 속성값들을 Update 해주는 메소드. (어떤 Match가 몇 개 맞았는지 Update)
	public static void fillResult(ArrayList<Match> matchList, ArrayList<MatchingResult> result) {
		for (int i = 0; i < matchList.size(); i++) {
			Match findMatch = matchList.get(i);
			exploreResult(findMatch, result);
		}
	}
	//result 를 돌면서 확인해주는 메소드.
	private static void exploreResult(Match match, ArrayList<MatchingResult> result) {
		for (int i = 0; i < result.size(); i++) {
			MatchingResult matchingResult = result.get(i);
			matchResultCount(match, matchingResult);
		}
	}
	//result 안의 Match 와 일치하는 Match 라면, Match의 수를 1 늘려주는 .match() 메소드 실행.
	private static void matchResultCount(Match match, MatchingResult matchingResult) {
		if (matchingResult.isMatch(match)) {
			matchingResult.match();
		}
	}
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	public double calculateMoney(ArrayList<MatchingResult> result, Money money) {
		double profit = 0;
		for (int i = 0; i < result.size(); i++) {
			MatchingResult matchingResult = result.get(i);
			profit += matchingResult.winningMoney();		//총 수익을 계산한다.
		}
		double yield = ((profit - money.getPrice()) / money.getPrice()) * 100;		//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		
		return yield;		//수익률을 리턴한다.
	}
}

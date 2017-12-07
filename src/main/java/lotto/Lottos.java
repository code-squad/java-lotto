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
	private ArrayList<Integer> rankList(ArrayList<Integer> winningNum, int bonus) {
		ArrayList<Integer> rankList = new ArrayList<Integer> ();		//티켓 별 맞은 번호 수를 등수로 변환하여 저장하는 리스트를 만들어준다.
		
		for (int i = 0; i < tickets.size(); i++) {
			rankList.add(tickets.get(i).matchCount(winningNum, bonus));		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 몇개가 일치하는지를 등수로 변환하여 리스트에 넣어줌.
		}
		return rankList;		//등수들이 저장되어 있는 리스트를 리턴한다.
	}
	//최종 결과 리스트를 만들어주는 메소드.
	public ArrayList<Integer> makeResult(ArrayList<Integer> winningNum, int bonus) {
		ArrayList<Integer> result = new ArrayList<Integer> ();		//최종 결과를 저장할 리스트.
		for(int i = 0; i < 5; i++) {
			int findNum = i + 1;		//3개(5등), 4개(4등), 5개(3등), 5개+보너스(2등), 6개(1등) 맞은 티켓의 수를 구하기 위한 변수. (등수로 검색한다.)
			result.add(i, countResult(rankList(winningNum, bonus), findNum));		//1등 한 횟수 ~ 5등 한 횟수 까지를 result 리스트에 추가해 카운트한다.
		}
		return result;
	}
	//맞은 숫자의 갯수를 카운트하고, 그 값을 리턴하는 메소드.
	private static int countResult(ArrayList<Integer> correct, int findNum) {
		int count = 0;
		for (int i = 0; i < correct.size(); i++) {
			count += howManyCorrect(correct.get(i), findNum);
		}
		return count;
	}
	//findNum 이 있으면 1 리턴, 없으면 0 리턴하는 메소드. 리턴값을 가지고 상위 메소드에서 count값을 증가시킴.
	private static int howManyCorrect(int correct, int findNum) {
		if(correct == findNum) {
			return 1;
		}
		return 0;
	}
	//맞은 갯수 비례 금액을 계산하여 총 딴 돈을 구한다. (내가 건 돈 만큼은 뺀다.)
	public int calculateMoney(ArrayList<Integer> result, int money) {
		int earnMoney = (result.get(4) * Match.valueOf(3, false).getWinningMoney()) + (result.get(3) * Match.valueOf(4, false).getWinningMoney())
						+ (result.get(2) * Match.valueOf(5, false).getWinningMoney()) + (result.get(1) * Match.valueOf(5, true).getWinningMoney()) +
						(result.get(0) * Match.valueOf(6, false).getWinningMoney()) - money;
		int yield = (earnMoney / money) * 100;		//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		
		return yield;		//수익률을 리턴한다.
	}
}

package lotto;

import java.util.ArrayList;

public class Lottos {
	private static final int MATCH3_MONEY = 5000;		//X개 맞았을 때의 상금을 상수값으로 지정.
	private static final int MATCH4_MONEY = 50000;
	private static final int MATCH5_MONEY = 1500000;
	private static final int MATCH6_MONEY = 2000000000;
	
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
	private ArrayList<Integer> correctList(ArrayList<Integer> winningNum) {
		ArrayList<Integer> correctList = new ArrayList<Integer> ();		//티켓 별 맞은 번호 수를 저장하는 리스트를 만들어준다.
		
		for (int i = 0; i < tickets.size(); i++) {
			correctList.add(tickets.get(i).matchCount(winningNum));		//각 티켓마다 winningNum과 일치하는 수가 있는지 계산하여 몇개가 일치하는지를 리스트에 넣어줌.
		}
		return correctList;
	}
	//최종 결과 리스트를 만들어주는 메소드.
	public ArrayList<Integer> makeResult(ArrayList<Integer> winningNum) {
		ArrayList<Integer> result = new ArrayList<Integer> ();		//최종 결과를 저장할 리스트.
		for(int i = 0; i < 4; i++) {
			int findNum = i + 3;		//3, 4, 5, 6개 맞은 티켓의 수를 구하기 위한 변수.
			result.add(i, countResult(correctList(winningNum), findNum));		//3개 맞은 횟수 ~ 6개 맞은 횟수 까지를 result 리스트에 추가해 카운트한다.
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
	public void calculateMoney(ArrayList<Integer> result, int money) {
		int earnMoney = (result.get(0) * MATCH3_MONEY) + (result.get(1) * MATCH4_MONEY)
						+ (result.get(2) * MATCH5_MONEY) + (result.get(3) * MATCH6_MONEY) - money;
		int yield = (earnMoney / money) * 100;		//건 돈 비례 번 돈을 계산한다. (수익률을 계산한다.)
		
		ResultView.printResult(result, yield);		//결과를 출력해준다.
	}
}

package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
	private ArrayList<Integer> num = new ArrayList<Integer> ();
	//생성자.
	public Lotto(ArrayList<Integer> ticket) {
		this.num = selectAutoNum(ticket);
	}
	//가능한 모든 로또 번호들을 List에 넣어서, 랜덤 수를 뽑아내는 모집단 List를 만든다. 
	private static ArrayList<Integer> makeTotalNum () {
		ArrayList<Integer> numCollection = new ArrayList<Integer> ();
		for (int i = 1; i <= 45; i++) {
			numCollection.add(i);
		}
		return numCollection;
	}
	//자동으로 6개의 숫자를 뽑아 로또 티켓 1장을 리턴한다.
	private ArrayList<Integer> selectAutoNum (ArrayList<Integer> ticket) {
		ArrayList<Integer> totalNumList = makeTotalNum();
		Collections.shuffle(totalNumList);
		ticket.addAll(totalNumList.subList(0,6));		//0번째에서 5번째까지만 추출한다.
		ticket = sortAutoNum(ticket);		//6개의 뽑힌 숫자를 정렬한다. (오름차순)
		return ticket;
	}
	//오름차순으로 숫자를 정렬해주는 메소드.
	private ArrayList<Integer> sortAutoNum(ArrayList<Integer> ticket) {
		Collections.sort(ticket);
		return ticket;
	}
	//각 로또 티켓마다의 번호를 확인하는 (리턴하는) 메소드.
	ArrayList<Integer> getNum() {
		return this.num;
	}
	//각 티켓마다 winningNum과 일치하는 숫자의 수를 계산하고, 티켓의 마지막에 그 수를 추가해준다.
	void matchCount(ArrayList<Integer> winningNum) {
		int count = 0;
		
		for (int i = 0; i < winningNum.size(); i++) {
			count += findToMatch(winningNum.get(i));
		}
		this.num.add(count);		//num의 마지막 값에 맞은 갯수를 추가한다.
	}
	//winningNum의 숫자가 티켓 안에 있다면 1을 리턴, 없다면 0을 리턴.
	int findToMatch(int winningNum) {
		if (this.num.contains(winningNum)) {
			return 1;
		}
		return 0;
	}
}

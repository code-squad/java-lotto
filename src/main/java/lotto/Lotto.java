package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
	private ArrayList<Integer> num = new ArrayList<Integer> ();
	//생성자.
	public Lotto() {
		this.num = selectAutoNum();
	}
	
	public Lotto(ArrayList<Integer> num) {
		this.num = num;
	}
	
	//가능한 모든 로또 번호들을 List에 넣어서, 랜덤 수를 뽑아내는 모집단 List를 만든다. 
	private ArrayList<Integer> makeTotalNum () {
		ArrayList<Integer> numCollection = new ArrayList<Integer> ();
		for (int i = 1; i <= 45; i++) {
			numCollection.add(i);
		}
		return numCollection;
	}
	//자동으로 6개의 숫자를 뽑아 로또 티켓 1장을 리턴한다.
	private ArrayList<Integer> selectAutoNum () {
		ArrayList<Integer> totalNumList = makeTotalNum();
		ArrayList<Integer> ticket = new ArrayList<Integer> ();
		Collections.shuffle(totalNumList);		//무작위로 모집단 수를 섞는다.
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
	public ArrayList<Integer> getNum() {
		return this.num;
	}
	//각 티켓마다 winningNum과 일치하는 숫자의 수를 계산하고, 일치하는 숫자의 수에 해당하는 등수(rank)를 리턴한다.
	public Match matchCount(ArrayList<Integer> winningNum, int bonus) {
		int count = 0;
		
		for (int i = 0; i < winningNum.size(); i++) {		//보너스 번호를 제외한 6개의 숫자만 비교하여 몇개 일치하는지 리턴해준다.
			count += findToMatch(winningNum.get(i));
		}
		return makeRank(count, bonus);
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

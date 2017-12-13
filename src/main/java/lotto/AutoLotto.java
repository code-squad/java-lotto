package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLotto extends Lotto {
	//자동 번호 로또를 생성해주는 생성자.
	public AutoLotto() {
		super(selectAutoNum());
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
	private static ArrayList<Integer> selectAutoNum () {
		ArrayList<Integer> totalNumList = makeTotalNum();
		ArrayList<Integer> ticket = new ArrayList<Integer> ();
		Collections.shuffle(totalNumList);		//무작위로 모집단 수를 섞는다.
		ticket.addAll(totalNumList.subList(0,6));		//0번째에서 5번째까지만 추출한다.
		ticket = sortAutoNum(ticket);		//6개의 뽑힌 숫자를 정렬한다. (오름차순)
		return ticket;
	}
	//오름차순으로 숫자를 정렬해주는 메소드.
	private static ArrayList<Integer> sortAutoNum(ArrayList<Integer> ticket) {
		Collections.sort(ticket);
		return ticket;
	}
}

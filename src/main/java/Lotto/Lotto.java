package Lotto;
import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
	private ArrayList<Integer> num = new ArrayList<Integer> ();
	//생성자.
	public Lotto(ArrayList<Integer> ticket) {
		this.num = ticket;
	}
	//가능한 모든 로또 번호들을 List에 넣어서, 랜덤 수를 뽑아내는 모집단 List를 만든다. 
	public static ArrayList<Integer> makeTotalNum () {
		ArrayList<Integer> numCollection = new ArrayList<Integer> ();
		for (int i = 1; i <= 45; i++) {
			numCollection.add(i);
		}
		return numCollection;
	}
	//자동으로 6개의 숫자를 뽑아 로또 티켓 1장을 리턴한다.
	public static ArrayList<Integer> selectAutoNum (ArrayList<Integer> ticket) {
		ArrayList<Integer> totalNumList = makeTotalNum();
		Collections.shuffle(totalNumList);
		for (int i = 0; i < 6; i++) {
			ticket.add(totalNumList.get(i));
		}
		ticket = sortAutoNum(ticket);		//6개의 뽑힌 숫자를 정렬한다. (오름차순)
		return ticket;
	}
	//오름차순으로 숫자를 정렬해주는 메소드.
	public static ArrayList<Integer> sortAutoNum(ArrayList<Integer> ticket) {
		Collections.sort(ticket);
		return ticket;
	}
	//각 로또 티켓마다의 번호를 확인하는 (리턴하는) 메소드.
	public ArrayList<Integer> getNum() {
		return this.num;
	}
}

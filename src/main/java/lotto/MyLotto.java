package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();

	MyLotto(int num) {
		this.myLotto = createRanLotto(num);
	}
	
	
	private ArrayList<Integer> wholeLottoNum() {
		ArrayList<Integer> wholeNum = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			wholeNum.add(i);
		}
		return wholeNum;
	}
	
	public ArrayList<Integer> createRanLotto(int num) {
		ArrayList<Integer> wholeNum = wholeLottoNum();
		Collections.shuffle(wholeNum);
		
		return new ArrayList<>(wholeNum.subList(0, 6));
	}

	public int compareNum(ArrayList<Integer> prizeNum) {
		this.myLotto.retainAll(prizeNum);
		return this.myLotto.size();
	}

	@Override
	public String toString() {
		return (myLotto != null ? myLotto : "") + "";
	}

}

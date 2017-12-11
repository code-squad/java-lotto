package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();

	MyLotto(int num) {
		this.myLotto = createRanLotto(num);
	}

	
	@Override
	public String toString() {
		return (myLotto != null ? myLotto : "") + "";
	}

	private ArrayList<Integer> wholeLottoNum(){
		ArrayList<Integer> wholeNum = new ArrayList<>();
		for (int i = 1;i < 46; i++) {
			wholeNum.add(i);
		}
		return wholeNum;
	}

	public ArrayList<Integer> createRanLotto(int num) {
		ArrayList<Integer> wholeNum = wholeLottoNum();
		Collections.shuffle(wholeNum);
		for (int i = 0; i < 6; i++) 
			myLotto.add(wholeNum.subList(0,45).get(i));
		return myLotto;
	}

	public int compareNum(ArrayList<Integer> prizeNum) {
		int sameNum = 0;
		for (int num : this.myLotto) {
			if (prizeNum.contains(num))
				sameNum++;
		}
		return sameNum;
	}
	
}

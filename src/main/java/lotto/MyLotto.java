package lotto;

import java.util.ArrayList;
import java.util.Random;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();
	private int size = 0;

	MyLotto(int num) {
		this.myLotto = createRanLotto(num);
	}

	public ArrayList<Integer> getMyLotto() {
		return this.myLotto;
	}
	
	private int getSize(){
		return this.size;
	}
	
	private void upSize(){
		this.size++;
	}

	public ArrayList<Integer> createRanLotto(int num) {
		while (getSize() != 6) {
			int ran = new Random().nextInt(46);
			if (!myLotto.contains(ran) && ran != 0) {
				myLotto.add(ran);
				upSize();
			}
		}
		return myLotto;
	}

}

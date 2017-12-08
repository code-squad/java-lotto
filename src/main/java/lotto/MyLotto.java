package lotto;

import java.util.ArrayList;
import java.util.Collections;
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

	private int getSize() {
		return this.size;
	}

	private void upSize() {
		this.size++;
	}

	public ArrayList<Integer> createRanLotto(int num) {
		Random random = new Random();
		while (getSize() != 6) {
			int ran = random.nextInt(45) + 1;
			if (!myLotto.contains(ran)) {
				myLotto.add(ran);
				upSize();
			}
		}
		Collections.shuffle(myLotto);
		return myLotto;
	}

}

package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class Lottos {
	private ArrayList<MyLotto> lottos = new ArrayList<>();
	private int lottoNum;

	Lottos(int num) {
		for (int i = 0; i < num; i++) {
			lottos.add(new MyLotto(num));
		}
		this.lottoNum = num;
	}

	public int getBuyNum() {
		return this.lottoNum;
	}

	public MyLotto getLottos(int index) {
		return lottos.get(index);
	}

	public ArrayList<Integer> compareLotto(ArrayList<Integer> winNum) {
		ArrayList<Integer> arrNum = initResult();
		for (int i = 0; i < lottos.size(); i++) {
			int sameNum = isExistNum(winNum, getLottos(i));
			arrNum = makeStatics(arrNum, sameNum);
		}

		return arrNum;
	}

	private ArrayList<Integer> initResult() {
		ArrayList<Integer> arrNum = new ArrayList<Integer>();
		for (int i = 0; i <= 6; i++)
			arrNum.add(i, 0);
		return arrNum;
	}

	public int isExistNum(ArrayList<Integer> winNum, MyLotto myLotto) {
		int sameNum = 0;
		for (int num : myLotto.getMyLotto()) {
			if (winNum.contains(num))
				sameNum++;
		}
		return sameNum;
	}

	private ArrayList<Integer> makeStatics(ArrayList<Integer> arrNum, int sameNum) {
		switch (sameNum) {
		case 3:
			arrNum.set(3, arrNum.get(3) + 1);
			break;
		case 4:
			arrNum.set(4, arrNum.get(4) + 1);
			break;
		case 5:
			arrNum.set(5, arrNum.get(5) + 1);
			break;
		case 6:
			arrNum.set(6, arrNum.get(6) + 1);
			break;
		}

		return arrNum;
	}

	public void sortLottos() {
		for (int i = 0; i < lottoNum; i++)
			Collections.sort(getLottos(i).getMyLotto());
	}
}

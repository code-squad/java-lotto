package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
	int commonCount = 0;
	boolean isBonus = false;
	
	public int getCommonCount() {
		return commonCount;
	}

	List <Integer> list = null;
	
	public Lotto() {
		makeLotto();
	}

	public Lotto(String manualLotto) {
		makeManualLotto(manualLotto);
	}
	
	public List<Integer> getList() {
		return list;
	}

	public void makeLotto() {
		list = new ArrayList<Integer>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
	}

	public void makeManualLotto(String manualLotto) {
		list = new ArrayList<Integer>();
		for(String num : manualLotto.split(",")) {
			list.add(Integer.parseInt(num.trim()));
		}
		Collections.sort(list);
	}

	public void addCommonCount() {
		commonCount ++;
	}
	
	public void isCommon(int num) {
		for(int lottoNum : list) {
			if(lottoNum == num) {
				addCommonCount();
			}
		}
	}
	
	public boolean isBonusCommon(int bonus) {
		for(int lottoNum : list) {
			if(lottoNum == bonus) {
				isBonus = true;
			}
		}
		return isBonus;
	}

	public boolean isBonus() {
		return isBonus;
	}
}
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningLotto extends Lotto {
	//private int bonus = 0; getBonus()부를 때 항상 0으로 초기화되어있음..
	//private int bonus; 잘 나옴
	//원인: 생성자에서 super(); 실행하면서 부모 생성자 안에 있는 makeLotto()를 실행함. 거기서 makeBonus()를 함. 
	//그 뒤 자식 생성자를 호출하면서 bonus = 0; 해버리니까 초기화되는 것. 
	//해결 방법: 생성자에서 객체를 makeLotto()를 부르지 않고 따로 호출한다. 
	
	private List<Integer> numbers;
	private int bonus = 0; 

	public WinningLotto(List<Integer> list, Integer bonus) {
		this.numbers = list;
		this.bonus = bonus;
	}

	public static WinningLotto initLotto() {
		List<Integer> list = new ArrayList<>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
		return new WinningLotto(list, range.get(6));
	}
	
	public int getBonus() {
		return bonus; 
	}

	private void makeBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public void makeLotto() {
		list = new ArrayList<>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
		makeBonus(range.get(6));
	}
}

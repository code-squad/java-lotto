package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WinningLotto extends Lotto {
	
	private int bonus;
	
	public int getBonus() {
		System.out.println("보너스: " + bonus);
		return bonus; 
	}

	private void makeBonus(int bonus) {
		this.bonus = bonus;
		System.out.println("보너스: " + this.bonus);
	}

	@Override
	public void makeLotto() {
		list = new ArrayList<Integer>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
		makeBonus(range.get(6));
	}
}

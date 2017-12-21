package model;

import java.util.ArrayList;
import java.util.List;

import model.WinStats.Result;

public class Count {
	private List<Integer> counts;

	public Count() {
		counts = new ArrayList<>();
		for (Result rank : Result.values()) {
			// 0 으로 초기화.
			counts.add(0);
		}
	}

	public void updateCount(int index) {
		// count 값 update 시키는 메소드.
		counts.add(counts.get(index) + 1);
	}

	public int getCountByIndex(WinStats.Result result) {
		return counts.get(result.getIndex());
	}
}

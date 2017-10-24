package lotto.model;

import java.util.HashMap;
import java.util.Set;

public class WinPrice {
	// HashMap key = 	matchNumber (일치한 개수)
	// 					int[0] = price (상금)
	// 					int[1] = matchCount (일치한 로또 수)
	private HashMap<Integer, int[]> winPrices = new HashMap<Integer, int[]>();

	public void addWinPrice(int matchNumber, int price) {
		int[] value = { price, 0 };
		winPrices.put(matchNumber, value);
	}

	public void addMatchCount(int matchNumber) {		
		if(winPrices.containsKey(matchNumber)) {
			int value[] = winPrices.get(matchNumber);
			value[1]++;
			winPrices.put(matchNumber, value);
		}		
	}
	
	public int[] get(int key) {
		return winPrices.get(key);
	}
	
	// 테스트용
	public int getMatchSumPrice(int matchNumber) {
		int value[] = winPrices.get(matchNumber);
		return value[0] * value[1];
	}

	public int getTotalSumPrice() {
		int totalPrice = 0;
		for (int key : winPrices.keySet()) {
			int value[] = winPrices.get(key);
			totalPrice += value[0] * value[1];
		}
		return totalPrice;
	}
	public Set<Integer> keySet(){
		return winPrices.keySet();
	}
}

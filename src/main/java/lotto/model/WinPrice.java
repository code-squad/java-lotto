package lotto.model;

import java.util.HashMap;
import java.util.Set;

public class WinPrice {
	private HashMap<Integer, WinPriceValue> winPrices = new HashMap<Integer, WinPriceValue>();

	public void addWinPrice(int matchNumber, int price) {
		winPrices.put(matchNumber, new WinPriceValue(price));
	}

	public void addMatchCount(int matchNumber) {
		if (winPrices.containsKey(matchNumber)) {
			WinPriceValue value = winPrices.get(matchNumber);
			value.addMatchCount();
			winPrices.put(matchNumber, value);
		}
	}

	// 테스트용
	public int getMatchSumPrice(int matchNumber) {
		return winPrices.get(matchNumber).getMatchCount();
	}

	public int getTotalSumPrice() {
		int totalPrice = 0;
		for (int key : winPrices.keySet()) {
			WinPriceValue value = winPrices.get(key);
			totalPrice += value.getTotalPrice();
		}
		return totalPrice;
	}

	public Set<Integer> keySet() {
		return winPrices.keySet();
	}

	public int getPrice(int key) {
		WinPriceValue winPriceValue = winPrices.get(key);
		return winPriceValue.getPrice();
	}

	public int getMatchCount(int key) {
		WinPriceValue winPriceValue = winPrices.get(key);
		return winPriceValue.getMatchCount();
	}
}

package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class WinPrice {
	public enum WinValue {
		FIFTH(3, 5000, "5등"), FOURTH(4, 50000, "4등"), THIRD(5, 1500000, "3등"), SECOND(5, 30000000, "2등(보너스 볼 일치)",
				true), FIRST(6, 2000000000, "1등");
		private int matchNum;
		private int price;
		private boolean bonusBall = false;
		private String rankString;

		WinValue(int matchNum, int price, String rankString) {
			this.matchNum = matchNum;
			this.price = price;
			this.rankString = rankString;
		}

		WinValue(int matchNum, int price, String rankString, boolean bonusBall) {
			this.matchNum = matchNum;
			this.price = price;
			this.rankString = rankString;
			this.bonusBall = bonusBall;
		}

		public int getMatchNum() {
			return matchNum;
		}

		public boolean getBonusBall() {
			return bonusBall;
		}

		public int getPrice() {
			return price;
		}

		public int getSumPrice(int matchCount) {
			return matchCount * price;
		}

		public String getRankString() {
			return rankString;
		}
	}

	private HashMap<WinValue, Integer> winPrices = new LinkedHashMap<WinValue, Integer>();

	public WinPrice() {
		winPrices.put(WinValue.FIFTH, 0);
		winPrices.put(WinValue.FOURTH, 0);
		winPrices.put(WinValue.THIRD, 0);
		winPrices.put(WinValue.SECOND, 0);
		winPrices.put(WinValue.FIRST, 0);
	}

	public WinValue valueOf(int matchNum, boolean bonusBall) {
		WinValue winValue = null;
		switch (matchNum) {
		case 3:
			winValue = WinValue.FIFTH;
			break;
		case 4:
			winValue = WinValue.FOURTH;
			break;
		case 5:
			winValue = checkBonusBall(bonusBall);
			break;
		case 6:
			winValue = WinValue.FIRST;
			break;
		}
		return winValue;
	}

	private WinValue checkBonusBall(boolean bonusBall) {
		if (bonusBall)
			return WinValue.SECOND;
		return WinValue.THIRD;
	}

	public void addMatchCount(int matchNum, boolean bonusBall) {
		if (matchNum >= 3) {
			WinValue winValue = valueOf(matchNum, bonusBall);
			int matchCount = winPrices.get(winValue);
			matchCount++;
			winPrices.put(winValue, matchCount);
		}
	}

	public int getMatchCount(WinValue winValue) {
		return winPrices.get(winValue);
	}

	public int getSumPrice(WinValue winValue) {
		return winValue.getSumPrice(winPrices.get(winValue));
	}

	public int getTotalSumPrice() {
		int totalPrice = 0;
		for (WinValue key : winPrices.keySet()) {
			totalPrice += getSumPrice(key);
		}
		return totalPrice;
	}

	public Set<WinValue> keySet() {
		return winPrices.keySet();
	}
}
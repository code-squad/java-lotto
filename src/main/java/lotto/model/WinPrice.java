package lotto.model;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;

public class WinPrice {
	private HashMap<WinValue, MatchCount> winPrices = new LinkedHashMap<WinValue, MatchCount>();

	public WinPrice() {
		winPrices.put(WinValue.FIFTH, new MatchCount());
		winPrices.put(WinValue.FOURTH, new MatchCount());
		winPrices.put(WinValue.THIRD, new MatchCount());
		winPrices.put(WinValue.SECOND, new MatchCount());
		winPrices.put(WinValue.FIRST, new MatchCount());
	}

	public WinValue valueOf(int matchNum, boolean bonusBall) {
		WinValue[] values = WinValue.values();
		for (WinValue winValue : values) {
			if (winValue.getMatchNum() == matchNum) {
				return checkMatchNum(winValue, bonusBall);
			}
		}
		throw new IllegalArgumentException(matchNum + "는 유효하지 않은 값입니다.");
	}

	private WinValue checkMatchNum(WinValue winValue, boolean bonusBall) {
		if (winValue.getMatchNum() == 5) {
			return checkBonusBall(bonusBall);
		}
		return winValue;
	}

	private WinValue checkBonusBall(boolean bonusBall) {
		if (bonusBall)
			return WinValue.SECOND;
		return WinValue.THIRD;
	}

	//이 코드가 짧아지는게 맞나
	public void addMatchCount(int matchNum, boolean bonusBall) {
		if (matchNum >= 3) {
			WinValue winValue = valueOf(matchNum, bonusBall);
			winPrices.get(winValue).addCount();
		}
	}

	public int getMatchCount(WinValue winValue) {
		return winPrices.get(winValue).getCount();
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

		public int getSumPrice(MatchCount matchCount) {
			return matchCount.getCount() * price;
		}

		public String getRankString() {
			return rankString;
		}
		
		public void addMatchCount(MatchCount matchCount) {
			matchCount.addCount();
		}
	}
}
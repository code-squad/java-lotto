package lotto.model;

public class WinPriceValue {
	private int price;
	private int matchCount = 0;

	public WinPriceValue(int price) {
		this.price = price;
	}

	public void addMatchCount() {
		matchCount++;
	}

	public int getPrice() {
		return price;
	}

	public int getMatchCount() {
		return matchCount;
	}

	public int getTotalPrice() {
		return price * matchCount;
	}
}

package lotto.domain;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	private Numbers numbers;
	
	public Lotto(Numbers numbers) {
		this.numbers = numbers;
	}
	
	public Lotto(int... numbers) {
		this.numbers = new Numbers(numbers);
	}
	
	public int countMatchNumbers(Numbers winNumbers) {
		return numbers.countMatch(winNumbers);
	}
}

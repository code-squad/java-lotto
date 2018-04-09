package lotto.domain;

public class Lotto {
	private int[] numbers;
	
	public Lotto(int... numbers) {
		this.numbers = numbers;
	}
	
	public int[] getNumbers() {
		return numbers;
	}
}

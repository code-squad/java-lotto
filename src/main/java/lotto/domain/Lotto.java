package lotto.domain;

public class Lotto {
	public static final int LOTTO_PRICE = 1000;
	public static final int LOTTO_NUMBERS_SIZE = 6;
	private Numbers numbers;
	
	public Lotto(Numbers numbers) {
		if(numbers.size() != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("Lotto는 6개의 번호를 가져야 합니다.");
		}
		this.numbers = numbers;
	}
	
	public Lotto(int... numbers) {
		if(numbers.length != LOTTO_NUMBERS_SIZE) {
			throw new IllegalArgumentException("Lotto는 6개의 번호를 가져야 합니다.");
		}
		this.numbers = new Numbers(numbers);
	}
	
	public Numbers getNumbers() {
		return numbers;
	}
	
	public long countMatchNumbers(Numbers winNumbers) {
		return numbers.countMatch(winNumbers);
	}
}

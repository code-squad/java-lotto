package lotto.db;

import java.util.List;

public class LottoDTO {
	private List<Integer> numbers;
	
	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers(List<Integer> numbers) {
		this.numbers = numbers;
	}
	

	public int getNumber(int i) {
		return numbers.get(i);
	}
	


}

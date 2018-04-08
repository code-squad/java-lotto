package calculator.domain;

public class Positive {
	private int number;
	
	public Positive(int number) {
		validate(number);
		this.number = number;
	}
	
	public Positive(String number) {
		int integerNumber = Integer.parseInt(number);
		validate(integerNumber);
		this.number = integerNumber;
	}
	
	private boolean validate(int number) {
		if(number < 0) {
			throw new RuntimeException("음수가 입력되었습니다.");
		}
		
		return true;
	}
	
	public int getNumber() {
		return number;
	}
	
	public Positive sum(Positive positive) {
		return new Positive(this.number + positive.getNumber());
	}
}

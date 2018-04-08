package calculator.domain;

public class Operand {
	private int operand;
	
	public Operand(int operand) {
		this.operand = operand;
	}
	
	public Operand(String operand) {
		this.operand = Integer.parseInt(operand);
	}
	
	public boolean isNegative() {
		return operand < 0;
	}
	
	public boolean validate() {
		if(isNegative()) {
			throw new RuntimeException("음수가 입력되었습니다.");
		}
		
		return true;
	}
	
	public int getOperand() {
		return operand;
	}
}

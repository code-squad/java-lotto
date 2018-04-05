package lotto.db;

public class ResultDTO {
	int turnNo;
	public int getTurnNo() {
		return turnNo;
	}

	public void setTurnNo(int turnNo) {
		this.turnNo = turnNo;
	}

	int first;
	int second;
	int third;
	int fourth;
	int fifth;
	int revenue;

	public int getRevenue() {
		return revenue;
	}

	public void setRevenue(int revenue) {
		this.revenue = revenue;
	}

	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public int getThird() {
		return third;
	}

	public void setThird(int third) {
		this.third = third;
	}

	public int getFourth() {
		return fourth;
	}

	public void setFourth(int fourth) {
		this.fourth = fourth;
	}

	public int getFifth() {
		return fifth;
	}

	public void setFifth(int fifth) {
		this.fifth = fifth;
	}

}

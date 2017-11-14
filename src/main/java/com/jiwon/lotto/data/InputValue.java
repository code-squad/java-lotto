package com.jiwon.lotto.data;

import java.util.List;

public class InputValue {
	private int money;
	private int numOfAutoLotto;
	private int numOfManualLotto;
	private List<String> manualLottoNums;
	private String lottery;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getNumOfAutoLotto() {
		return numOfAutoLotto;
	}

	public void setNumOfAutoLotto(int numOfAutoLotto) {
		this.numOfAutoLotto = numOfAutoLotto;
	}

	public int getNumOfManualLotto() {
		return numOfManualLotto;
	}

	public void setNumOfManualLotto(int numOfManualLotto) {
		this.numOfManualLotto = numOfManualLotto;
	}

	public List<String> getManualLottoNums() {
		return manualLottoNums;
	}

	public void setManualLottoNums(List<String> manualLottoNums) {
		this.manualLottoNums = manualLottoNums;
	}

	public String getLottery() {
		return lottery;
	}

	public void setLottery(String lottery) {
		this.lottery = lottery;
	}

}

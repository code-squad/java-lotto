package com.sangco.lotto.model;

public class WinLottoState {
	private static WinLottoState list;
	private int three = 0;
	private int four = 0;
	private int five = 0;
	private int six = 0;
	private int bonus = 0;

	public static WinLottoState getInstance() {
		if (list == null) {
			list = new WinLottoState();
		}
		return list;
	}

	public void countWin(int imp, Boolean isBonus) {
		if (imp == 3)
			three++;
		if (imp == 4)
			four++;
		if (imp == 5 & isBonus == false)
			five++;
		if (imp == 5 & isBonus == true)
			bonus++;
		if (imp == 6)
			six++;
	}

	public int getWinnerData(int passNumb, Boolean isBonus) {
		if (passNumb == 3)
			passNumb = three;
		if (passNumb == 4)
			passNumb = four;
		if (passNumb == 5 & isBonus == false)
			passNumb = five;
		if (passNumb == 5 & isBonus == true)
			passNumb = bonus;
		if (passNumb == 6)
			passNumb = six;
		return passNumb;
	}

	public int getBonus() {
		return bonus;
	}
}

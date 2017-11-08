package com.jiwon.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jiwon.lotto.lottocreator.WinningLotto;

public class InputView {
	Scanner sc = new Scanner(System.in);
	public int getMoney() {
		System.out.println("구입금액을 입력해 주세요.");
		int money = sc.nextInt();
		return money;
	}
	public int getNumOfAutoLotto() {
		System.out.println("자동생성할 로또 개수를 입력하세요.");
		int numOfAutoLotto = sc.nextInt();
		return numOfAutoLotto;
	}
	public int getNumOfManualLotto() {
		System.out.println("수동생성할 로또 개수를 입력하세요.");
		int numOfManualLotto = sc.nextInt();
		return numOfManualLotto;
	}
	public List<String> getManualLottoNum(int numOfManualLotto) {
		List<String> usrInputs = new ArrayList<>();
		for(int i=0; i < numOfManualLotto; i++) {
			System.out.println("수동생성 로또 번호를 입력하세요.");
			usrInputs.add(new Scanner(System.in).next());
		}
		return usrInputs;
	}
	public String getLottery() {
		System.out.println("지난 주 당첨번호를 추첨하려면 'lottery' 를 입력하세요.");
		// exception 처리 가능.
		return (new Scanner(System.in)).next();
	}
	public void autoDraw() {
		if(sc.next() == "lottery") {
			WinningLotto winningLotto = new WinningLotto();
		}
	}
}

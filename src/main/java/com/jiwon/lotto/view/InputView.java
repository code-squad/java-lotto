package com.jiwon.lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jiwon.lotto.data.InputValue;

public class InputView {
	public static InputValue createValue() {
		// DTO 를 반환하는 클래스.
		InputValue iv = new InputValue();
		System.out.println("구입금액을 입력해 주세요.");
		Scanner sc = new Scanner(System.in);
		iv.setMoney(sc.nextInt());
		ResultView.printNumOfLotto(iv.getMoney()/1000);
		System.out.println("자동생성할 로또 개수를 입력하세요.");
		iv.setNumOfAutoLotto(sc.nextInt());
		System.out.println("수동생성할 로또 개수를 입력하세요.");
		iv.setNumOfManualLotto(sc.nextInt());
		List<String> manualLottoNums = new ArrayList<>();
		for (int i = 0; i < iv.getNumOfManualLotto(); i++) {
			System.out.println("수동생성 로또 번호를 입력하세요.");
			manualLottoNums.add(sc.next());
		}
		iv.setManualLottoNums(manualLottoNums);
		System.out.println("지난 주 당첨번호를 추첨하려면 'lottery' 를 입력하세요.");
		// exception 처리 가능.
		iv.setLottery(sc.next());
		sc.close();
		return iv;
	}
}

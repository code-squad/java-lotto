package com.jiwon.lotto.lottocreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jiwon.lotto.lotto.AutoLotto;
import com.jiwon.lotto.lotto.CandidateLottoSet;
import com.jiwon.lotto.lotto.Lotto;
import com.jiwon.lotto.lotto.ManualLotto;
import com.jiwon.lotto.lotto.WinningLotto;

public class LottoCreator {
	// 메소드 안에 상태 instance 변수가 포함된 로직이 아예 존재하지 않으므로 static으로 설정하는 것이 적당.
	public static List<Integer> makeNum() {
		// 1부터 45까지의 숫자를 넣은 리스트 반환.
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i < 46; i++) {
			numbers.add(i);
		}
		return numbers;
	}
	
	public static List<Integer> processUsrInput(String lottoNumString) {
		List<Integer> manualLottoNums = new ArrayList<>();
		for (String s : lottoNumString.split(",")) {
			if (Integer.parseInt(s) < 46) {
				manualLottoNums.add(Integer.parseInt(s));
			}
		}
		return manualLottoNums;
	}
	
	public static AutoLotto makeAutoLotto() {
		// 로또 하나 자동생성 [1,2,3,4,5,6]
		List<Integer> numbers = makeNum();
		Collections.shuffle(numbers);
		Collections.sort(numbers.subList(0, 6));
		return new AutoLotto(numbers.subList(0, 6));
	}
	
	public static ManualLotto makeManualLotto(String lottoNumString) {
		// lotto 하나 생성.
		List<Integer> numbers = processUsrInput(lottoNumString);
		Collections.sort(numbers);
		return new ManualLotto(numbers);
	}
	
	public static WinningLotto makeWinningLotto() {
		List<Integer> numbers = makeNum();
		Collections.shuffle(numbers);
		Collections.sort(numbers.subList(0, 6));
		/* 회고글에 기록하기 */
		return new WinningLotto(numbers.subList(0, 6), numbers.get(6));
	}
	
	public static List<AutoLotto> makeAutoLottos(int numOfAutoLotto){
		List<AutoLotto> autoLottos = new ArrayList<>(); 
		for (int i=0; i < numOfAutoLotto; i++) {
			autoLottos.add(LottoCreator.makeAutoLotto());
		}
		return autoLottos;
	}
	public static List<ManualLotto> makeManualLottos(int numOfManualLotto, List<String> lottoNumStrings){
		List<ManualLotto> manualLottos = new ArrayList<>();
		for(String lottoNumString : lottoNumStrings) {
			manualLottos.add(LottoCreator.makeManualLotto(lottoNumString));
		}
		return manualLottos;
	}

}

package com.jiwon.lotto.lottocreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.jiwon.lotto.lotto.Lotto;

public class AutoLotto extends Lotto {
	static List<Integer> numList;
	protected Lotto lotto;
	private List<Lotto> autoLottos = new ArrayList<Lotto>();
	
	public AutoLotto() {
		makeNum();
	}
	
	public static List<Integer> makeNum(){
		// 1부터 45까지의 숫자를 넣은 리스트 반환.
		numList = new ArrayList<Integer>();
		for(int i=1; i < 46; i++){
			numList.add(i);
		}
		return numList;
	}
	
	public void create() {
		// 로또 하나 자동생성 [1,2,3,4,5,6]
		lotto = new Lotto();
		Collections.shuffle(numList);
		lotto.setNumbers(IntStream.range(0, 6)
							.map(i -> numList.get(i))
							.boxed().sorted().collect(Collectors.toList()));
	}
	
	public List<Lotto> makeAutoLottos(int numOfAutoLotto) {
		// 여러개의 autolotto를 만드는 메소드.
		for(int i=0; i < numOfAutoLotto; i++) {
			create();
			autoLottos.add(lotto);
		}
		return autoLottos;
	}
}

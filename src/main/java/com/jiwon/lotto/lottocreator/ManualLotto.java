package com.jiwon.lotto.lottocreator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jiwon.lotto.lotto.Lotto;

public class ManualLotto extends Lotto {
	private Lotto lotto; 
	private List<Lotto> manualLottos = new ArrayList<Lotto>();
	
	public Lotto create(String usrInput) {
		// lotto 하나 생성.
		lotto = new Lotto();
		List<Integer> numbers = processUsrInput(usrInput);
		Collections.sort(numbers);
		lotto.setNumbers(numbers);
		return lotto;
	}
	
	public List<Integer> processUsrInput(String usrInput){
		String[] strings = usrInput.split(",");
		List<Integer> numbers = new ArrayList<>();
		for(String string : strings) {
			if(Integer.parseInt(string) < 46) {
				numbers.add(Integer.parseInt(string));
			}
		}
		return numbers;
	}
	
	public List<Lotto> makeManualLottos(int numOfManualLotto, List<String> usrInputs) {
		ManualLotto manualLotto = new ManualLotto();
		for(String usrInput : usrInputs) {
			manualLottos.add(manualLotto.create(usrInput));
		}
		return manualLottos;
	}
	

}

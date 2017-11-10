package com.lotto.model;

import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lotto.model.strategy.LottoPurchaseStrategy;

public class UserLotto {
	
	private static final Logger log = LoggerFactory.getLogger(UserLotto.class);
	
	private List<Integer> numbers;
	private LottoPurchaseStrategy lps;
	private Scanner scn;
	
	private UserLotto() {}
	
	public UserLotto(LottoPurchaseStrategy lps, Scanner scn) {
		this.scn = scn;
		this.lps = lps;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	public void setNumbers() {
		log.info("로또 번호 생성 중!");
		this.numbers = lps.selectNumbers(scn);
	}
}

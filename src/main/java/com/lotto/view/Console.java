package com.lotto.view;

import java.util.List;
import java.util.Scanner;

import com.google.common.collect.Lists;
import com.lotto.model.UserLotto;
import com.lotto.model.WinningLotto;
import com.lotto.model.strategy.LottoPurchaseStrategy;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory;
import com.lotto.model.strategy.NumberGenerateStrategy;
import com.lotto.model.strategy.NumberGenerateStrategyFactory;

public class Console {

	private List<UserLotto> generatedLottos = Lists.newArrayList();
	private WinningLotto winningLotto;
	private LottoPurchaseStrategyFactory lpsf;
	private NumberGenerateStrategyFactory ngsf;
	private Scanner scn;

	public Console(LottoPurchaseStrategyFactory lpsf, NumberGenerateStrategyFactory ngsf) {
		this.lpsf = lpsf;
		this.ngsf = ngsf;
	}

	public void prompt() {

		this.scn = new Scanner(System.in);

		System.out.println(ConsoleMessages.INPUT_PROMPT);
		String input = scn.nextLine();
		System.out.println(ConsoleMessages.INPUT_PROMPT_PURCHASE);
		String typeInput = scn.nextLine();

		generateLottos(lottoAmount(input), this.lpsf.getPurchaseStrategy(typeInput));

		System.out.println(ConsoleMessages.INPUT_PROMPT_WINNINGTYPE);

		generateWinningLotto(this.ngsf.getStrategy(scn.nextLine()));
		setLottoNumbers();
		setWinningNumber();

	}

	public List<UserLotto> getUserLottos() {
		return this.generatedLottos;
	}

	public WinningLotto getWinningLotto() {
		return this.winningLotto;
	}

	private void generateLottos(int count, LottoPurchaseStrategy lps) {
		for (int i = 0; i < count; i++) {
			this.generatedLottos.add(new UserLotto(lps, scn));
		}
	}

	private void generateWinningLotto(NumberGenerateStrategy ngs) {
		this.winningLotto = new WinningLotto(ngs);
	}

	private int lottoAmount(String input) {
		return Integer.parseInt(input) / 1000;
	}

	private void setLottoNumbers() {
		this.generatedLottos.stream().forEach(ul -> ul.setNumbers());
	}

	private void setWinningNumber() {
		this.winningLotto.setWinningNumbers();
	}

}

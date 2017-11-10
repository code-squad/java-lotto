package com.lotto.container;

import java.util.List;

import com.lotto.model.Game;
import com.lotto.model.UserLotto;
import com.lotto.model.WinningLotto;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory;
import com.lotto.model.strategy.NumberGenerateStrategyFactory;
import com.lotto.view.Console;

public class LottoContainer {
	
	private static final LottoContainer lc = new LottoContainer();
	
	private LottoContainer() {}
	
	public static LottoContainer getInstance() {
		return lc;
	}
	
	private static final LottoPurchaseStrategyFactory lpsf = LottoPurchaseStrategyFactory.getInstance();
	private static final NumberGenerateStrategyFactory ngs = NumberGenerateStrategyFactory.getInstance();
	private Game game;
	private List<UserLotto> inputLottos;
	private WinningLotto winNumbers;
	private Console console;
	
	
	public void initialize() {
		lpsf.initialize();
		ngs.initialize();
		this.console = new Console (lpsf, ngs);
		this.console.prompt();
		this.inputLottos = this.console.getUserLottos();
		this.winNumbers = this.console.getWinningLotto();
		this.game = new Game(this.inputLottos, this.winNumbers);
	}
	
	public void destroy() {
		
	}
	
	public void execute() {
		System.out.println(this.game.getResultsByString());
	}

}

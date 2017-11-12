package com.lotto.container;

import com.lotto.model.Game;
import com.lotto.model.strategy.LottoPurchaseStrategyFactory;
import com.lotto.model.strategy.NumberGenerateStrategyFactory;
import com.lotto.view.Console;

public class LottoContainer {

	private static final LottoPurchaseStrategyFactory lpsf = LottoPurchaseStrategyFactory.getInstance();
	private static final NumberGenerateStrategyFactory ngs = NumberGenerateStrategyFactory.getInstance();
	private Game game;



	private static final LottoContainer lc = new LottoContainer();

	private LottoContainer() {
	}

	public static LottoContainer getInstance() {
		return lc;
	}

	public void initialize() {
		lpsf.initialize();
		ngs.initialize();
		Console console = new Console(lpsf, ngs);
		console.prompt();

		this.game = new Game(console.getUserLottos(), console.getWinningLotto());
	}

	public void destroy() {
		//TODO 컨테이너 생명주기 관리를 위한 destroy() 구현
	}

	public void execute() {
		System.out.println(this.game.getResultsByString());
	}

}
